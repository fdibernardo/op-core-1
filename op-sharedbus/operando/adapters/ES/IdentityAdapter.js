/*
 * Copyright (c) 2016 ROMSOFT.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the The MIT License (MIT).
 * which accompanies this distribution, and is available at
 * http://opensource.org/licenses/MIT
 *
 * Contributors:
 *    RAFAEL MASTALERU (ROMSOFT)
 * Initially developed in the context of OPERANDO EU project www.operando.eu
 */

var core = require("swarmcore");
core.createAdapter("IdentityManager");

var apersistence = require('apersistence');
var container = require("safebox").container;

var flow = require("callflow");

apersistence.registerModel("Identity", "Redis", {
        userId: {
            type: "string",
            index: true
        },
        email: {
            type: "string",
            index: true,
            pk: true
        },
        isDefault:{
            type: "boolean",
            default: false,
            index:true
        },
        isReal:{
            type: "boolean",
            default: false
        }
    },
    function (err, model) {
        if (err) {
            console.log(err);
        }
    }
);

container.declareDependency("IdentityManager", ["redisPersistence"], function (outOfService, redisPersistence) {
    if (!outOfService) {
        console.log("Enabling persistence...", redisPersistence);
    } else {
        console.log("Disabling persistence...");
    }
});


createIdentity = function (identityData, callback) {
    flow.create("create identity", {
        begin: function () {
            redisPersistence.lookup.async("Identity", identityData.email, this.continue("createIdentity"));
        },
        createIdentity: function (err, identity) {

            if (err) {
                callback(err, null);
            }
            else {
                if (!redisPersistence.isFresh(identity)) {
                    callback(new Error("identity_email_should_be_unique"), null);
                }
                else {
                    redisPersistence.externalUpdate(identity, identityData);
                    redisPersistence.saveObject(identity, callback);

                }
            }
        }
    })();
};

generateIdentity = function(callback){
    flow.create("generateIdentity",{
        begin:function(){
            var identity = generateString();
            console.log(identity);
            redisPersistence.lookup.async("Identity", identity, this.continue("generateIdentity"));
        },
        generateIdentity: function(err, identity){
            if(redisPersistence.isFresh(identity)){
                callback(null, identity);
            }
            else{
                this.begin();
            }
        }
    })();
};

deleteIdentity = function (identityData, callback) {
    flow.create("delete identity", {
        begin: function () {
            if (!identityData.email) {
                callback(new Error("empty_email"), null);
            }
            else {

                redisPersistence.findById("Identity", identityData.email, this.continue("deleteIdentity"));
            }
        },

        deleteIdentity: function (err, identity) {
            if (err) {
                callback(err, null);
            }
            else if (identity != null) {
                if(identity.isDefault == true){
                    callback(new Error("could_not_delete_default_identity"), null);
                }
                if(identity.isReal == true){
                    callback(new Error("could_not_delete_your_real_identity"), null);
                }
                else{
                    redisPersistence.delete(identity, callback);
                }

            }
            else{
                if(identity == null){
                    callback(new Error("identity_not_exists"), null);
                }
            }
        }
    })();
};

getIdentities = function (userId, callback) {
    if (!userId) {
        callback(new Error("userId_is_required"), null);
    }
    else {
        redisPersistence.filter("Identity", {"userId": userId}, callback);
    }
};

setDefaultIdentity = function(identity, callback){
    flow.create("set default identity",{
        begin:function(){
            if(!identity){
                callback(new Error("no_identity_provided"), null);
            }
            else {
                redisPersistence.filter("Identity", {isDefault:true, userId:identity.userId}, this.continue("clearCurrentDefaultIdentity"));
            }
        },

        clearCurrentDefaultIdentity:function(err, identities){
            var self = this;
            console.log(identities);
            if(identities.length>0){
                identities.forEach(function(_identity, index){
                    _identity.isDefault = false;
                    (function (index) {
                        redisPersistence.saveObject(_identity, function () {
                            if (index == identities.length-1) {
                                self.next("retrieveCurrentIdentity");
                            }
                        })
                    })(index);
                });
            }
            else {
                self.next("retrieveCurrentIdentity");
            }
        },

        retrieveCurrentIdentity:function(){
            redisPersistence.findById("Identity", identity.email, this.continue("updateNewIdentity"));
        },
        updateNewIdentity:function(err, identity){
            if(err){
                callback(err, null);
            }
            else{
                identity.isDefault = true;
                redisPersistence.saveObject(identity, callback);
            }
        }
    })();
}

setRealIdentity = function(user, callback){

    flow.create("add real identity",{

        begin:function(){
            redisPersistence.lookup.async("Identity", user.email, this.continue("addRealIdentity"));
        },

        addRealIdentity:function(err, identity){
            if(err){
                callback(err, null);
            }
            else{
                if (!redisPersistence.isFresh(identity)) {
                    callback(new Error("This identity already exists"), null);
                }
                else{
                    identity.isReal = true;
                    identity.isDefault = true;
                    identity.email = user.email
                    identity.userId = user.userId;
                    redisPersistence.saveObject(identity, callback);
                }
            }
        }

    })();
};

getUserId = function(proxyEmail,callback){
    redisPersistence.findById("Identity",proxyEmail,function(err,result){
        if(err){
            callback(err);
            return;
        }
        if(result===null){
            callback(new Error("Proxy "+proxyEmail+" is not registered"));
            return;
        }
        callback(err,result.userId);
    })
};

function generateString(){
    return Math.floor((1 + Math.random()) * 0x100000000000000)
        .toString(36)
        .substring(1);
}


