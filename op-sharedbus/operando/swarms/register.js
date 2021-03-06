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

var registerSwarming = {

    meta: {
        name: "register.js"
    },

    vars: {
        newUser: null,
        erorr: null
    },

    registeNewUser: function (newUserData) {
        console.log("New user register request", newUserData);
        this.newUser = newUserData;
        this.swarm("verifyUserData");
    },

    verifyValidationCode: function () {
        //Confirm user identity and activate account
    },

    verifyUserData: {
        node: "UsersManager",
        code: function () {
            var self = this;

            newUserIsValid(self.newUser, S(function (err, user) {
                if (err) {
                    console.log(err);
                    self.status = "error";
                    self.error = err.message;
                    self.newUser = {}
                    self.home("error");
                } else {
                    self.swarm("generateValidationCode");
                }
            }))
        }
    },

/*    saveNewUser: {
        node: "UserManager",
        code: function () {
            var self = this;
            createUser(this.newUser, S(function (err, user) {
                if (err) {
                    console.log("ERR");
                    self.error = self.err,
                        self.swarm("error");
                } else {

                    self.swarm("success");
                }
            }));
        }
    },*/

    generateValidationCode: {
        node: "UsersManager",
        code: function () {
            this.home("success");
        }
    },


}

registerSwarming;