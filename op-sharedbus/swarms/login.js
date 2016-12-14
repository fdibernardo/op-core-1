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

/*
 TODO: check to be clean in production, this is an ideal place where you can put a backdoor for your authentication
 */

sessionsRegistry = require("../lib/SessionRegistry.js").getRegistry();

var loginSwarming = {
    meta: {
        debug: false
    },
    vars: {
        authenticated: false,
        sessionId: null,
        userId: null
    },
    userLogin: function (email, authorisationToken) {
        console.log(email);
        this.sessionId = this.getSessionId();
        this.authenticated = false;
        this.email = email;
        if (!email || email.length === 0) {
            this.swarm('failed', this.getEntryAdapter());
            return;
        }
        this.authorisationToken = authorisationToken;
        this.clientAdapter = thisAdapter.nodeName;
        this.swarm('checkPassword');

    },
    checkPassword: {
        node: "UsersManager",
        code: function () {
            var self = this;
            validatePassword(this.email, this.authorisationToken, S(function (err, userId) {
                if (err) {
                    self.swarm("failed", self.getEntryAdapter());
                }
                else if (userId) {
                    console.log(userId);
                    self.userId = userId;
                    self.authenticated = true;
                    self.swarm("createOrUpdateSession");
                }
            }));
        }
    },

    logout: function () {
        console.log("logout");
        this.sessionId = this.getSessionId();
        this.swarm("userLogout");
    },

    userLogout: {
        node: "SessionManager",
        code: function () {
            var self = this;
            deleteUserSessions(this.getSessionId(), S(function (err, result) {
                if (err) {
                    console.log(err);
                }
                else {
                    self.home("logoutSucceed");
                    sessionsRegistry.disableOutlet(self.meta.outletId);
                }
            }));

        }
    },

    restoreSession: function (userId, clientSessionId) {
        console.log(this.meta.sessionId, clientSessionId);
        if (clientSessionId == null || clientSessionId == undefined) {
            this.home("restoreFailed");
        }
        else {
            console.log("Let's restore session");
            this.sessionId = clientSessionId;
            this.outletSession = this.getSessionId();
            this.userId = userId;
            this.swarm("validateSession");
        }
    },

    validateSession: {
        node: "SessionManager",
        code: function () {
            var self = this;

            if (!self.sessionId) {
                self.home("restoreFailed");
            }

            else {
                sessionIsValid(self.outletSession, self.sessionId, self.userId, S(function (err, newSession) {

                    if (err) {
                        console.log(err.message);
                        self.home("restoreFailed");
                    }
                    else {
                        if (newSession) {
                            console.log("Session is valid");
                            self.sessionId = newSession.sessionId;
                            self.authenticated = true;
                            self.swarm("restoreSwarms", self.getEntryAdapter());
                        }
                        else {
                            self.home("restoreFailed");
                        }
                    }
                }));
            }

        }
    }
    ,

    //It is not used anywhere
    reconnectInSession: function (clientSessionId, userId, secretToken) {
        this.authenticated = false;
        this.setSessionId(clientSessionId);
        this.userId = userId;
        this.secretToken = secretToken;
        this.swarm("reconnect");
    },
    testCtor: function (clientSessionId, userId, authorisationToken) {
        this.authenticated = false;
        this.userId = userId;
        this.authorisationToken = authorisationToken;
        this.clientAdapter = thisAdapter.nodeName;
        console.log("Password: ", authorisationToken);
        if (authorisationToken == "ok") {
            this.authenticated = true;
            cprint("enabling... " + this.clientAdapter);
            this.swarm("enableSwarms", this.getEntryAdapter());
        } else {
            this.swarm("failed", this.getEntryAdapter());
            cprint("disabling... " + this.clientAdapter);
        }
    },
    reconnect: {   //add this new outlet in sessions
        node: "EntryPoint",
        code: function () {
            var outlets = sessionsRegistry.findOutletsForSession(this.getSessionId());
            for (var v in outlets) {
                if (outlets[v].getSecret() == this.secretToken) {
                    this.swarm("enableSwarm", this.getEntryAdapter());
                    return;
                }
            }
            this.home("failed");
        }
    },
    failed: {   //phase
        node: "EntryPoint",
        code: function () {
            sessionsRegistry.disableOutlet(this.meta.outletId);
            logger.info("Failed login for " + this.userId);
            this.home("failed");
        }
    },
    enableSwarms: {   //phase that is never executed... given as documentation
        node: "EntryPoint",
        code: function () {
            console.log("swarms enabled",this.userId);
            this.meta.userId = this.userId;
            var outlet = sessionsRegistry.getTemporarily(this.meta.outletId);
            sessionsRegistry.registerOutlet(outlet);
            enableOutlet(this);
            console.log("Success !");
            if(this.email==="guest@operando.eu"){
                this.home("success_guest");
            }
            else{
                this.home("success");
            }
        }
    },
    restoreSwarms: {   //phase that is never executed... given as documentation
        node: "EntryPoint",
        code: function () {
            var outlet = sessionsRegistry.getTemporarily(this.meta.outletId);
            sessionsRegistry.registerOutlet(outlet);
            enableOutlet(this);
            console.log("Session restored for ", this.userId, "!");
            this.home("restoreSucceed");
        }
    },

    createOrUpdateSession: {
        node: "SessionManager",
        code: function () {
            var self = this;
            if (this.sessionId == null || this.sessionId == undefined) {
                this.sessionId = this.getSessionId();
            }
            var sessionData = {
                userId: self.userId,
                sessionId: self.sessionId
            };

            createOrUpdateSession(sessionData, S(function (error, session) {
                if (error) {
                    console.log(error);
                }
                else {
                    //console.log("Current session", session);
                    self.swarm("enableSwarms", self.getEntryAdapter());
                }
            }));
        }
    }
};

loginSwarming;