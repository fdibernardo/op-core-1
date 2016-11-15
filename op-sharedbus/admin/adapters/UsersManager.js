/**
 * Created by salboaie on 3/24/15.
 */

/*
 Default UsersManager adapter. Punct de integrare cu alte sisteme, gen casa de sanatate.
 */
var core = require("swarmcore");
/*
 usersmanager este un adaptor swarm care gestioneaza organizatiile si utilizatorii

 */

core.createAdapter("UsersManager");


var apersistence = require('apersistence');
const crypto = require('crypto');


var container = require("safebox").container;


var flow = require("callflow");

var passwordMinLength = 4;
var usernameMinLength = 4;

var saveCallbackFn = function (err, obj) {
    if (err) {
        console.log(err);
    }
}

/*
 Model de date pentru organizatie

 */

apersistence.registerModel("Organisation", "Redis", {
    ctor: function () {
    },
    organisationId: {
        type: "string",
        pk: true,
        index: true
    },
    displayName: {
        type: "string"
    },
    agent: {
        /* numele de grup al agentului */
        type: "string"
    }
}, function (err, model) {
    if (err) {
        console.log(err);
    }

});

/*
 Default User model
 */

apersistence.registerModel("DefaultUser", "Redis", {
    userId: {
        type: "string",
        pk: true,
        index: true
    },
    userName: {
        type: "string"
    },
    organisationId: {
        type: "string",
        index: true
    },
    password: {
        type: "string"
    },
    birthYear: {
        type: "string"
    },
    birthMonth: {
        type: "string"
    },
    birthDay: {
        type: "string"
    },
    sex: {
        type: "string"
    },
    phone: {
        type: "string"
    },
    email: {
        type: "string",
        index:true
    },
    address: {
        type: "string"
    },
    city: {
        type: "string"
    },
    zip_code: {
        type: "string"
    },
    is_active: {
        type: "boolean"
    },
    salt:{
        type:"string"
    }
}, function (err, model) {
    if (err) {
        console.log(err);
    }
});

/*
 Creeaza un utilizator
 */

createUser = function (userData, callback) {
    flow.create("create user", {
        begin: function () {
            if (!userData.userId) {
                callback(new Error('Empty userId'), null);
            }
            else {
                redisPersistence.lookup("DefaultUser", userData.userId, this.continue("createPassword"));
            }
        },
        createPassword:function(err,user){
            if(!redisPersistence.isFresh(user)){
                callback(new Error("User with identical id " + userData.userId + " already exists"), null);
            }else{
                this.user = user;
                userData.salt = crypto.randomBytes(48).toString('base64');
                hashThisPassword(userData.password,userData.salt,this.continue('createUser'));
            }
        },
        createUser: function (err, hashedPassword) {
            userData.password = hashedPassword;
            redisPersistence.externalUpdate(this.user, userData);
            redisPersistence.save(this.user, this.continue("createReport"));
        },
        createReport: function (err, user) {
            if (user.password) {
                delete user['password'];
            }
            callback(err, user);
        }
    })();
};





/*
 Filtreaza utilizatorii
 */
filterUsers = function(conditions,callback){
    redisPersistence.filter("DefaultUser",conditions,callback);
};

/*
 Sterge un utilizator
 */

deleteUser = function (userData) {
    flow.create("delete user", {
        begin: function () {
            redisPersistence.deleteById("DefaultUser", userData.userId, this.continue("deleteReport"));
        },
        deleteReport: function (err, obj) {
            callback(err, obj);
        }
    })();
};


/*
 Sterge o organizatie
 */


deleteOrganisation = function (organisationId) {
    flow.create("delete organisation", {
        begin: function () {
            redisPersistence.deleteById("Organisation", organisationId, this.continue("deleteReport"));
        },
        deleteReport: function (err, obj) {
            callback(err, obj);
        }
    })();
}

/*
 Updateaza informatiile unui utilizator
 */

updateUser = function (userJsonObj, callback) {
    flow.create("update user", {
        begin: function () {
            redisPersistence.lookup.async("DefaultUser", userJsonObj.userId, this.continue("updateUser"));
        },
        updateUser: function (err, user) {
            if (err) {
                callback(err, null);
            }
            else {
                if (redisPersistence.isFresh(user)) {
                    callback(new Error("User with id " + userJsonObj.userId + " does not exist"), null);
                }
                else {
                    //redisPersistence.delete(user);
                    //redisPersistence.externalUpdate(user, userJsonObj);

                    for(var field in userJsonObj){
                        user[field] = userJsonObj[field];
                    }
                    redisPersistence.saveObject(user, this.continue("updateReport"));
                }
            }
        },
        updateReport: function (err, user) {
            callback(err, user);
        }
    })();
}

/*
 queryUsers returneaza lista utilizatorilor apartinind de o organizatie
 */

queryUsers = function (organisationId, callback) {
    flow.create("get organisation users", {
        begin: function () {
            redisPersistence.filter("DefaultUser", {"organisationId": organisationId}, this.continue("getOrganisationUsers"));
        },
        getOrganisationUsers: function (err, users) {
            var organizationUsers = [];

            users.forEach(function (user) {
                if (user.is_active != false) {
                    delete user['password'];
                    organizationUsers.push(user);
                }
            });

            callback(err, organizationUsers);
        }
    })();
}

/*
 Creeaza o organizatie
 */

createOrganisation = function (organisationDump, callback) {
    flow.create("create organisation", {
        begin: function () {
            redisPersistence.lookup("Organisation", organisationDump.organisationId, this.continue("createOrganisation"));
        },
        createOrganisation: function (err, organisation) {
            if (err) {
                callback(err, null);
            }
            else {
                if (!redisPersistence.isFresh(organisation)) {
                    callback(new Error("Organisation with id " + organisationDump.organisationId + " already exists"), null);
                }
                else {
                    redisPersistence.externalUpdate(organisation, organisationDump);
                    redisPersistence.saveObject(organisation, this.continue("createReport"));
                }
            }
        },
        createReport: function (err, organisation) {
            callback(err, organisation);
        }
    })();
}

/*
 Realizeaza salvarea datelor despre o organizatie
 */

updateOrganisation = function (organisationDump, callback) {
    flow.create("update organization", {
        begin: function () {
            redisPersistence.lookup("Organisation", organisationDump.organisationId, this.continue("updateOrganisation"));
        },

        updateOrganisation: function (err, organisation) {
            if (err) {
                callback(err, null);
            }

            else if (redisPersistence.isFresh(organisation)) {
                callback(new Error("Organisation with id " + organisationDump.organisationId + " was not found"), null);
            }
            else {
                redisPersistence.externalUpdate(organisation, organisationDump);
                redisPersistence.saveObject(organisation, this.continue("updateReport"));
            }
        },
        updateReport: function (err, organisation) {
            callback(err, organisation);
        }
    })();
};


newUserIsValid = function (newUser, callback) {
    flow.create("user is valid", {
        begin: function () {

            if(!newUser.email){
                callback(new Error("Email is invalid!"));
            }
            else

            if(!newUser.username || newUser.username.length < usernameMinLength){
                callback(new Error("Username is too short!"));
            }
            else

            if(!newUser.password || newUser.password.length < passwordMinLength){
                callback(new Error("Password must contain at least "+passwordMinLength+" characters"));
            }

            else{
                redisPersistence.lookup("DefaultUser", newUser.username, this.continue("verifyEmail"))
            }

        },
        verifyEmail: function (err, user) {
            if (err) {
                callback(err);
            } else if (!redisPersistence.isFresh(user)) {
                callback(new Error("Username is unavailable"));
            }
            else {
                redisPersistence.lookup("DefaultUser", newUser.email, this.continue("verifyPasswords"))
            }
        },
        verifyPasswords: function (err, user) {
            if (err) {
                callback(err);
            }
            else if (!redisPersistence.isFresh(user)) {
                callback(new Error("Email is unavailable"));
            }
            else {
                if (newUser.password != newUser.repeat_password) {
                    callback(new Error("Passwords doest not match"));
                }
                else {
                    createUser({
                        userId: newUser.email,
                        password: newUser.password,
                        userName: newUser.username,
                        email: newUser.email,
                        organisationId: "Public"
                    }, function (err, user) {
                        if (user) {
                            if (user['password']) {
                                delete user['password'];
                            }
                        }
                        callback(err, user);
                    });
                }
            }
        }
    })();
}


/*
 Returneaza lista de organizatii
 */

getOrganisations = function (callback) {
    flow.create("get all organizations", {
        begin: function () {
            redisPersistence.filter("Organisation", this.continue("info"));
        },
        info: function (err, result) {
            callback(err, result);
        }
    })();
}


/*
 Returneaza informatii despre un utilizator
 */

getUserInfo = function (userId, callback) {
    flow.create("retrieve user info", {
        begin: function () {
            redisPersistence.findById("DefaultUser", userId, this.continue("info"));
        },
        info: function (err, user) {
            if (err) {
                callback(err, null);
            } else if (user) {
                if (user.password) {
                    delete user['password'];
                    delete user['salt'];
                }
                callback(null, user);
            }
            else {
                callback(null, null);
            }
        }
    })();
}

validPassword = function (userId, pass, callback) {
    flow.create("Validate Password", {
        begin: function () {
            redisPersistence.findById("DefaultUser", userId, this.continue("validatePassword"));
        },
        validatePassword: function (err, user) {
            if (err || !user) {
                callback(err, null);
            }
            else{
                hashThisPassword(pass,user.salt,function(err,hashedPassword){
                    if(err){
                        callback(err);
                    }
                    else if(hashedPassword===user.password){
                        callback(null,true);
                    }else{
                        callback(null,false);
                    }
                })
            }
        }
    })();
}

changeUserPassword = function(userId, currentPassword, newPassword, callback){
    flow.create("Validate Password", {
        begin: function () {

            if (newPassword === currentPassword) {
                callback(new Error("You should enter different passwords"), false);
            }
            else if (newPassword.length < passwordMinLength) {
                callback(new Error("Your new password it too short! It should have at least " + passwordMinLength + " characters "), false);
            }
            else{
                redisPersistence.findById("DefaultUser", userId, this.continue("validatePassword"));
            }
        },
        validatePassword: function (err, user) {
            var self = this;
            if (err || ! user) {
                callback(err, null);
            }
            else{
                hashThisPassword(currentPassword,user.salt,function(err,hashedPassowrd){
                    if(hashedPassowrd===user.password){
                        self.storeNewPassword(user,newPassword);
                    }else{
                        callback("The password you provided does not match our records")
                    }
                })
            }
        },
        storeNewPassword:function(user,newPassword){
            user.salt = crypto.randomBytes(48).toString('base64');
            hashThisPassword(newPassword,user.salt,function(err,hashedPassword){
                user.password = hashedPassword;
                redisPersistence.saveObject(user,callback);
            });
        }
    })();
}

function bootSystem() {
    flow.create("bootSystem", {
        begin: function () {
            redisPersistence.lookup("Organisation", "SystemAdministrators", this.continue("createOrganisation"));
            redisPersistence.lookup("Organisation", "Public", this.continue("createPublicOrganisation"));
            redisPersistence.lookup("Organisation", "Analysts", this.continue("createAnalystOrganisation"));

        },
        createPublicOrganisation: function (err, organisation) {
            if (redisPersistence.isFresh(organisation)) {
                organisation.displayName = "OPERANDO PUBLIC";
                redisPersistence.saveObject(organisation, this.continue("createGuestUser"));
            }
        },
        createOrganisation: function (err, organisation) {
            if (redisPersistence.isFresh(organisation)) {
                organisation.displayName = "System Administrators";
                redisPersistence.saveObject(organisation, this.continue("createAdministrators"));
            }
        },
        createAdministrators: function (err, organisation) {
            if (err) {
                console.log("Error occurred on creating organisation", err);
            }
            else {
                createUser({
                    userId: "admin",
                    password: "swarm",
                    email:"admin@operando.eu",
                    userName: "Admin",
                    organisationId: organisation.organisationId
                }, saveCallbackFn);
            }
        },
        createGuestUser: function (err, organisation) {
            if (err) {
                console.log("Error occurred on creating organisation", err);
            }
            else {
                createUser({
                    userId: "guest",
                    password: "guest",
                    userName: "Guest User",
                    organisationId: organisation.organisationId
                }, saveCallbackFn);
            }
        },

        createAnalystOrganisation:function(err, organisation){
            if (redisPersistence.isFresh(organisation)) {
                organisation.displayName = "OPERANDO ANALYSTS";
                redisPersistence.saveObject(organisation, this.continue("createAnalystUser"));
            }
        },

        createAnalystUser:function(err, organisation){
            if(err){
                console.log("Error when creating OPERANDO ANALYSTS organisation");
            }
            else{
                createUser({
                    userId: "analyst",
                    password: "analyst",
                    email:"analyst@rms.ro",
                    userName: "Analyst Guru",
                    organisationId: organisation.organisationId
                }, saveCallbackFn);
            }
        }

    })();
}

function hashThisPassword(plainPassword,salt,callback){
    return crypto.pbkdf2(plainPassword, salt, 100000, 512, 'sha512',function(err,res){
        if(err){
            callback(err)
        }
        else{
            callback(undefined,res.toString('base64'));
        }
    });
}

container.declareDependency("UsersManagerAdapter", ["redisPersistence"], function (outOfService, redisPersistence) {
    if (!outOfService) {
        console.log("Enabling persistence...", redisPersistence);
        bootSystem();
    } else {
        console.log("Disabling persistence...");
    }
});

setTimeout(function(){
    updateUser({userId:"admin",organisationId:"Public"},console.log)
},2000);
