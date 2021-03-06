/////////////////////////////////////////////////////////////////////////
//
// © University of Southampton IT Innovation Centre, 2016
//
// Copyright in this software belongs to University of Southampton
// IT Innovation Centre of Gamma House, Enterprise Road,
// Chilworth Science Park, Southampton, SO16 7NS, UK.
//
// This software may not be used, sold, licensed, transferred, copied
// or reproduced in whole or in part in any manner or form or in or
// on any media by any person other than in accordance with the terms
// of the Licence Agreement supplied with the software, or otherwise
// without the prior written consent of the copyright owners.
//
// This software is distributed WITHOUT ANY WARRANTY, without even the
// implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
// PURPOSE, except where stated in the Licence Agreement supplied with
// the software.
//
//      Created By :            Panos Melas
//      Created Date :          2016-04-28
//      Created for Project :   OPERANDO
//
/////////////////////////////////////////////////////////////////////////
package eu.operando.core.pdb.api.impl;

import eu.operando.core.pdb.common.model.AccessReason;

import io.swagger.api.ApiResponseMessage;
import io.swagger.api.NotFoundException;

import io.swagger.api.OSPApiService;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import eu.operando.core.pdb.common.model.OSPPrivacyPolicyInput;
import eu.operando.core.pdb.common.model.OSPReasonPolicyInput;
import eu.operando.core.pdb.mongo.OSPPrivacyPolicyMongo;
import io.swagger.client.ApiClient;
import io.swagger.client.api.LogApi;
import io.swagger.client.model.LogRequest;
import io.swagger.client.model.LogRequest.LogLevelEnum;
import io.swagger.client.model.LogRequest.LogPriorityEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import eu.operando.core.cas.client.api.DefaultApi;
//import eu.operando.core.cas.client.ApiException;
import eu.operando.core.cas.client.model.UserCredential;
import io.swagger.client.ApiException;
import io.swagger.client.model.LogRequest.LogTypeEnum;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import javax.ws.rs.core.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-20T12:05:17.950Z")
public class OSPApiServiceImpl extends OSPApiService {

    // LogDB
    LogApi logApi;
    // AAPI
    DefaultApi aapiClient;

    String pdbOSPSId = "pdb/OSP/.*";
    String logdbSId = "ose/osps/.*";
    String aapiBasePath = "http://integration.operando.esilab.org:8135/operando/interfaces/aapi";
    String logdbBasePath = "http://integration.operando.esilab.org:8090/operando/core/ldb";
    String oseBasePath = "http://integration.operando.esilab.org:8094/operando/core/ose";
    String ospLoginName = "xxxxx";
    String ospLoginPassword = "xxxxx";
    String stHeaderName = "Service-Ticket";
    String logdbST = "";
    long ticketLifeTime = 1000L * 60 * 60;

    String mongoServerHost = "localhost";
    int mongoServerPort = 27017;
    OSPPrivacyPolicyMongo ospMongodb = null;
    Timer timer;

    Properties prop = null;

    public OSPApiServiceImpl() {
        super();
        //  get service config params
        prop = loadServiceProperties();
        loadParams();

        // setup aapi client
        eu.operando.core.cas.client.ApiClient aapiDefaultClient = new eu.operando.core.cas.client.ApiClient();
        aapiDefaultClient.setBasePath(aapiBasePath);
        this.aapiClient = new DefaultApi(aapiDefaultClient);

        // setup logdb client
        final ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(logdbBasePath);

        TimerTask timerTask = new TimerTask() {
            //@Override
            public void run() {
                Logger.getLogger(OSPApiServiceImpl.class.getName()).log(Level.INFO, "TIMER RUN now");
                logdbST = getServiceTicket(ospLoginName, ospLoginPassword, logdbSId);
                apiClient.addDefaultHeader(stHeaderName, logdbST);
            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, ticketLifeTime);

        // get service ticket for logdb service
        logdbST = getServiceTicket(ospLoginName, ospLoginPassword, logdbSId);
        apiClient.addDefaultHeader(stHeaderName, logdbST);
        this.logApi = new LogApi(apiClient);

        // setup mongo part
        ospMongodb = new OSPPrivacyPolicyMongo(mongoServerHost, mongoServerPort);
    }

    private void loadParams() {
        // setup aapi client
        if (prop.getProperty("aapi.basepath") != null) {
            aapiBasePath = prop.getProperty("aapi.basepath");
        }

        // setup logdb client
        if (prop.getProperty("logdb.basepath") != null) {
            logdbBasePath = prop.getProperty("logdb.basepath");
        }

        // get service ticket for logdb service
        if (prop.getProperty("pdb.osp.service.login") != null) {
            ospLoginName = prop.getProperty("pdb.osp.service.login");
        }
        if (prop.getProperty("pdb.osp.service.password") != null) {
            ospLoginPassword = prop.getProperty("pdb.osp.service.password");
        }
        if (prop.getProperty("logdb.service.id") != null) {
            logdbSId = prop.getProperty("logdb.service.id");
        }

        // setup mongo part
        if (prop.getProperty("mongo.server.host") != null) {
            mongoServerHost = prop.getProperty("mongo.server.host");
        }
        if (prop.getProperty("mongo.server.port") != null) {
            try {
                mongoServerPort = Integer.parseInt(prop.getProperty("mongo.server.port"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private Properties loadServiceProperties() {
        Properties props;
        props = new Properties();

        InputStream is = null;
        try {
            is = this.getClass().getClassLoader().getResourceAsStream("service.properties");
            props.load(is);
        } catch (IOException e) {
            // Display to console for debugging purposes.
            System.err.println("Error reading Configuration service properties file");
            // Add logging code to log an error configuring the API on startup
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return props;
    }

    private String getServiceTicket(String username, String password, String serviceId) {
        String st = null;

        UserCredential userCredential = new UserCredential();
        userCredential.setUsername(username);
        userCredential.setPassword(password);

        try {
            String tgt = aapiClient.aapiTicketsPost(userCredential);
            System.out.println("pdb osp service TGT: " + tgt);
            st = aapiClient.aapiTicketsTgtPost(tgt, serviceId);
            System.out.println("logdb osp service ticket: " + st);

        } catch (eu.operando.core.cas.client.ApiException ex) {
            ex.printStackTrace();
        }
        return st;
    }

    private boolean aapiTicketsStValidateGet(String st) {
        try {
            aapiClient.aapiTicketsStValidateGet(st, pdbOSPSId);
        } catch (eu.operando.core.cas.client.ApiException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean validateHeaderSt(HttpHeaders headers) {
        return true;
    }

    private boolean validateHeaderSt1(HttpHeaders headers) {
        if (headers != null) {
            List<String> stHeader = headers.getRequestHeader(stHeaderName);
            if (stHeader != null) {
                String st = stHeader.get(0);
                try {
                    aapiClient.aapiTicketsStValidateGet(st, pdbOSPSId);
                    Logger.getLogger(RegulationsApiServiceImpl.class.getName()).log(Level.INFO,
                            "Service Ticket validation succeeded");
                    return true;
                } catch (eu.operando.core.cas.client.ApiException ex) {
                    Logger.getLogger(RegulationsApiServiceImpl.class.getName()).log(Level.WARNING,
                            "Service Ticket validation failed: {0}", ex.getMessage());
                    return false;
                }
            }
        }
        return false;

    }

    private void logRequest1(String requesterId, String title, String description,
            LogLevelEnum logDataType, LogPriorityEnum logPriority, String affectedId,
            ArrayList<String> keywords) {
        Logger.getLogger(OSPApiServiceImpl.class.getName()).log(Level.INFO, "REPLACE LogDB call {0}", title);
    }

    private void logRequest(String requesterId, String title, String description,
            LogLevelEnum logLevel, LogPriorityEnum logPriority, LogRequest.LogTypeEnum logType,
            String affectedId, ArrayList<String> keywords) {

        ArrayList<String> words = new ArrayList<String>(Arrays.asList("PDB", "OSP"));
        for (String word : keywords) {
            words.add(word);
        }

        LogRequest logRequest = new LogRequest();
        logRequest.setUserId("PDB-OSP");
        logRequest.setRequesterType(LogRequest.RequesterTypeEnum.PROCESS);

        logRequest.setDescription(description);
        logRequest.setLogLevel(logLevel);
        logRequest.setTitle(title);
        logRequest.setLogPriority(logPriority);
        logRequest.setRequesterId(requesterId);
        logRequest.setLogType(logType);
        logRequest.setAffectedUserId(affectedId);

        logRequest.setKeywords(words);

        try {
            String response = this.logApi.lodDB(logRequest);
            Logger.getLogger(UserPrivacyPolicyApiServiceImpl.class.getName()).log(Level.INFO, response);
        } catch (ApiException ex) {
            Logger.getLogger(UserPrivacyPolicyApiServiceImpl.class.getName()).log(Level.SEVERE, "failed to log", ex);
        }
    }

    @Override
    public Response oSPGet(String filter, SecurityContext securityContext, HttpHeaders headers) throws NotFoundException {

        Logger.getLogger(OSPApiServiceImpl.class.getName()).log(Level.INFO, "OSP GET (filter) {0}", filter);

        if (!validateHeaderSt(headers)) {
            return Response.status(403).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error. The service ticket failed to validate.")).build();
        }

        logRequest("PDB OSP", "GET OSP",
                "OSP GET received",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, "",
                new ArrayList<String>(Arrays.asList("PDB", "OSP", "received")));

        String ospString = ospMongodb.getOSPByFilter(filter);

        if (ospString == null) {

            logRequest("PDB OSP", "GET OSP",
                    "OSP GET failed",
                    LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, "",
                    new ArrayList<String>(Arrays.asList("PDB", "OSP", "failed")));

            return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error - the regulation does not exist")).build();
        }

        logRequest("PDB OSP", "GET OSP",
                "OSP GET ok",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, "",
                new ArrayList<String>(Arrays.asList("PDB", "OSP", "ok")));

        return Response.ok(ospString, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response oSPOspIdPrivacyPolicyAccessReasonsGet(String ospId, SecurityContext securityContext, HttpHeaders headers) throws NotFoundException {

        Logger.getLogger(OSPApiServiceImpl.class.getName()).log(Level.INFO, "OSP GET Access Reasons(id) {0}", ospId);

        if (!validateHeaderSt(headers)) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error. The service ticket failed to validate.")).build();
        }

        logRequest("OSP GET access reasons", "GET",
                "OSP GET access reasons received",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("one", "two")));

        String ospString = ospMongodb.getOSPAccessReasonsById(ospId);

        if (ospString == null) {

            logRequest("OSP GET access reasons", "GET",
                    "OSP GET access reasons failed",
                    LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                    new ArrayList<String>(Arrays.asList("one", "two")));

            return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error - the OSP access policies does not exist")).build();
        }

        logRequest("OSP GET access reasons", "GET",
                "OSP GET access reasons complete",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("one", "two")));

        return Response.ok(ospString, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response oSPOspIdDelete(String ospId, SecurityContext securityContext, HttpHeaders headers) throws NotFoundException {
        Logger.getLogger(OSPApiServiceImpl.class.getName()).log(Level.INFO, "OSP DELETE {0}", ospId);

        if (!validateHeaderSt(headers)) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error. The service ticket failed to validate.")).build();
        }

        logRequest("OSP DELETE", "DELETE",
                "OSP DELETE received",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("one", "two")));

        boolean delAction = ospMongodb.deleteOSPById(ospId);

        if (!delAction) {

            System.out.println("cannot delete regulation " + ospId);

            logRequest("OSP DELETE", "DELETE",
                    "OSP DELETE failed",
                    LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                    new ArrayList<String>(Arrays.asList("one", "two")));

            return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error. No document exits to be deleted")).build();
        }

        logRequest("OSP DELETE", "DELETE",
                "OSP DELETE complete",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("one", "two")));

        return Response.status(Response.Status.NO_CONTENT).entity(new ApiResponseMessage(ApiResponseMessage.OK,
                "The document (OSPBehaviour) was successfully deleted from the database.")).build();
    }

    @Override
    public Response oSPOspIdGet(String ospId, SecurityContext securityContext, HttpHeaders headers) throws NotFoundException {

        Logger.getLogger(OSPApiServiceImpl.class.getName()).log(Level.INFO, "OSP GET (id) {0}", ospId);

        if (!validateHeaderSt(headers)) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error. The service ticket failed to validate.")).build();
        }

        logRequest("OSP GET1", "GET",
                "OSP GET received",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("one", "two")));

        String ospString = ospMongodb.getOSPById(ospId);

        if (ospString == null) {

            logRequest("OSP GET2", "GET",
                    "OSP GET failed",
                    LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                    new ArrayList<String>(Arrays.asList("one", "two")));

            return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error - the regulation does not exist")).build();
        }

        logRequest("OSP GET3", "GET",
                "OSP GET complete",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("one", "two")));

        return Response.ok(ospString, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response oSPOspIdPrivacyPolicyGet(String ospId, SecurityContext securityContext, HttpHeaders headers) throws NotFoundException {

        Logger.getLogger(OSPApiServiceImpl.class.getName()).log(Level.INFO, "OSP GET Privacy Policy {0}", ospId);

        if (!validateHeaderSt(headers)) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error. The service ticket failed to validate.")).build();
        }

        logRequest("OSP GET", "GET",
                "OSP GET received",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("one", "two")));

        String ospString = ospMongodb.getPolicyOSPById(ospId);

        if (ospString == null) {

            logRequest("OSP GET", "GET",
                    "OSP GET failed",
                    LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                    new ArrayList<String>(Arrays.asList("one", "two")));

            return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error - the reason policy does not exist")).build();
        }

        logRequest("OSP GET", "GET",
                "OSP GET complete",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("one", "two")));

        return Response.ok(ospString, MediaType.APPLICATION_JSON).build();
    }

    /**
     * Get a specific user policy from the policy DB.
     * @userId The id of the user.
     * @return A JSON string representing their UPPs.
     */
    private String callOSEComponent(String ospId, String policyText) {
        try {
            /**
             * Invoke the PDB to query for the user consents.
             */
            CloseableHttpClient httpclient = HttpClients.createDefault();
            String utl = oseBasePath + "/osps/"+ ospId + "/reason";
            HttpPut httpput = new HttpPut(utl);
            httpput.setHeader("Content-type", "application/json");
            httpput.setEntity(new StringEntity(policyText));
            CloseableHttpResponse response1 = httpclient.execute(httpput);

            System.out.println(response1.getEntity());
            /**
             * If there is no response return null.
             */
            if(response1.getStatusLine().getStatusCode()==404) {
                return "" + response1.getStatusLine();
            }
            httpclient.close();
            response1.close();
            httpput.releaseConnection();

            return "" + response1.getStatusLine() + "Info - log " + utl + ":" + policyText;
        } catch (IOException ex) {
            System.err.println("OSE-Compliance-Report: Unable to retrieve data from Policy Database");
            return "error";
        }
    }

    @Override
    public Response oSPOspIdPrivacyPolicyAccessReasonsPost(String ospId, AccessReason ospPolicy, SecurityContext securityContext, HttpHeaders headers) throws NotFoundException {

        Logger.getLogger(OSPApiServiceImpl.class.getName()).log(Level.INFO, "OSP POST Access Reasons(id) {0}", ospId);

        if (!validateHeaderSt(headers)) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error. The service ticket failed to validate.")).build();
        }

        logRequest("OSP POST access reasons", "POST",
                "OSP POST access reasons received",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("one", "two")));

        boolean ospString = ospMongodb.privacyPolicyAccessReasonsPost(ospId, ospPolicy);

        if (!ospString) {

            logRequest("OSP POST access reasons", "POST",
                    "OSP POST access reasons failed",
                    LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                    new ArrayList<String>(Arrays.asList("one", "two")));

            return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error - the OSP access policies does not exist")).build();
        }

        logRequest("OSP POST access reasons", "POST",
                "OSP POST access reasons complete",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("one", "two")));

        // TODO: response should be created 201 not 200?
        return Response.ok(ospString, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response oSPOspIdPrivacyPolicyAccessReasonsReasonIdDelete(String ospId, String reasonId, SecurityContext securityContext, HttpHeaders headers) throws NotFoundException {

        Logger.getLogger(OSPApiServiceImpl.class.getName()).log(Level.INFO, "OSP DELETE Access Reason(id) {0}", ospId);

        if (!validateHeaderSt(headers)) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error. The service ticket failed to validate.")).build();
        }

        logRequest("OSP DELETE access reason", "DELETE",
                "OSP DELETE access reason received",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("one", "two")));

        boolean response = ospMongodb.accessReasonIdDelete(ospId, reasonId);

        if (!response) {

            logRequest("OSP DELETE access reason", "DELETE",
                    "OSP DELETE access reason failed",
                    LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                    new ArrayList<String>(Arrays.asList("one", "two")));

            return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error - the OSP access policies does not exist")).build();
        }

        logRequest("OSP DELETE access reason", "DELETE",
                "OSP DELETE access reason complete",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("one", "two")));

        //return Response.ok("OK", MediaType.APPLICATION_JSON).build();
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Override
    public Response oSPOspIdPrivacyPolicyAccessReasonsReasonIdPut(String ospId, String reasonId, AccessReason ospPolicy, SecurityContext securityContext, HttpHeaders headers) throws NotFoundException {
        try{
            Logger.getLogger(OSPApiServiceImpl.class.getName()).log(Level.INFO, "OSP PUT Access Reason(id) {0}", ospId);

            if (!validateHeaderSt(headers)) {
                return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                        "Error. The service ticket failed to validate.")).build();
            }

            String errorMsg = callOSEComponent(ospId, ospPolicy.toString());
            logRequest("OSP PUT access reason", "PUT", "OSP PUT access reason received",
                    LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                    new ArrayList<String>(Arrays.asList(ospId, ospPolicy.toString())));

            boolean response = ospMongodb.accessReasonIdUpdate(ospId, reasonId, ospPolicy);

            if (!response) {
                logRequest("OSP PUT access reason", "PUT", "OSP PUT access reason failed",
                        LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                        new ArrayList<String>(Arrays.asList("one", "two")));

                return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                        "Error - the OSP access policies does not exist")).build();
            }

            logRequest("OSP PUT access reason", "PUT",
                    "OSP PUT access reason complete",
                    LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                    new ArrayList<String>(Arrays.asList("one", "two")));

            // TODO return 204
            return Response.ok("OK", MediaType.APPLICATION_JSON).entity("The OSP ID is " + errorMsg).build();
        }
        catch(Exception ex){
            return Response.ok("OK", MediaType.APPLICATION_JSON).entity("The error  is " + ex.getMessage()).build();
        }

    }

    @Override
    public Response oSPOspIdPrivacyPolicyPut(String ospId, OSPReasonPolicyInput ospPolicy, SecurityContext securityContext, HttpHeaders headers) throws NotFoundException {

        Logger.getLogger(OSPApiServiceImpl.class.getName()).log(Level.INFO, "OSP Privacy Policy PUT {0}", ospId);

        if (!validateHeaderSt(headers)) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error. The service ticket failed to validate.")).build();
        }

        logRequest("OSP PUT request: ", ospId + " Privacy Policy change requested",
                ospId + " requested to change their Privacy Policy.",
                LogLevelEnum.INFO, LogPriorityEnum.HIGH, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("PUT")));

        boolean ret = ospMongodb.updateReasonPolicyOSP(ospId, ospPolicy);

        if (!ret) {

            logRequest("OSP PUT request: ", ospId + " Privacy Policy change requested",
                    ospId + " has failed to change their Privacy Policy.",
                    LogLevelEnum.ERROR, LogPriorityEnum.HIGH, LogTypeEnum.NOTIFICATION, ospId,
                    new ArrayList<String>(Arrays.asList("PUT")));

            return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error - the reason policy does not exist")).build();
        }

        logRequest("OSP PUT request: ", ospId + " Privacy Policy change",
                ospId + " changed their Privacy Policy. Take a look at their Privacy Policy for details.",
                LogLevelEnum.INFO, LogPriorityEnum.HIGH, LogTypeEnum.NOTIFICATION, ospId,
                new ArrayList<String>(Arrays.asList("PUT")));;

        return Response.status(Response.Status.NO_CONTENT).build();
        //return Response.ok("OK", MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response oSPOspIdPut(String ospId, OSPPrivacyPolicyInput ospPolicy, SecurityContext securityContext, HttpHeaders headers) throws NotFoundException {

        Logger.getLogger(OSPApiServiceImpl.class.getName()).log(Level.INFO, "OSP PUT {0}", ospId);

        if (!validateHeaderSt(headers)) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error. The service ticket failed to validate.")).build();
        }

        logRequest("OSP PUT", "PUT",
                "OSP PUT received",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("one", "two")));

        boolean updateAction = ospMongodb.updateOSP(ospId, ospPolicy);

        if (!updateAction) {

            logRequest("OSP PUT", "PUT",
                    "OSP PUT failed",
                    LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                    new ArrayList<String>(Arrays.asList("one", "two")));

            return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error. No document exists to be updated.")).build();
        }

        logRequest("OSP PUT", "PUT",
                "OSP PUT complete",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, ospId,
                new ArrayList<String>(Arrays.asList("one", "two")));

        return Response.status(Response.Status.NO_CONTENT).entity(new ApiResponseMessage(ApiResponseMessage.OK,
                "The document (OSPBehaviour) was successfully updated in the database.")).build();
    }

    @Override
    public Response oSPPost(OSPPrivacyPolicyInput ospPolicy, SecurityContext securityContext, HttpHeaders headers)
            throws NotFoundException {

        Logger.getLogger(OSPApiServiceImpl.class.getName()).log(Level.INFO, "received OSP POST {0}", ospPolicy.toString());

        if (!validateHeaderSt(headers)) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error. The service ticket failed to validate.")).build();
        }

        logRequest("OSP POST", "POST",
                "OSP POST received",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, "",
                new ArrayList<String>(Arrays.asList("one", "two")));

        String ospId = ospMongodb.storeOSP(ospPolicy);

        if (ospId == null) {

            logRequest("OSP POST", "POST",
                    "OSP POST failed",
                    LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, "",
                    new ArrayList<String>(Arrays.asList("one", "two")));

            return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                    "Error. The document (OSPBehaviour) at this id has previously been created in the database.")).build();
        }

        logRequest("OSP POST", "POST",
                "OSP POST complete",
                LogLevelEnum.INFO, LogPriorityEnum.NORMAL, LogTypeEnum.SYSTEM, "",
                new ArrayList<String>(Arrays.asList("one", "two")));

//        return Response.status(Response.Status.CREATED).entity(new ApiResponseMessage(ApiResponseMessage.OK,
//                ospId)).build();
        Response resp = null;
        try {
            URI createdURI = new URI("http://integration.operando.esilab.org:8096/operando/core/pdb/OSP/" + ospId);
            resp = Response.created(createdURI).entity(ospId).build();
        } catch (URISyntaxException ex) {
            Logger.getLogger(OSPApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

//        return Response.status(Response.Status.CREATED).header("Location", "http://integration.operando.esilab.org:8096/operando/core/pdb/OSP/" + ospId).
//                entity(new ApiResponseMessage(ApiResponseMessage.OK, ospId)).build();
        return resp;
    }

    /*
    @Override
    public Response oSPGet(String filter, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response oSPOspIdDelete(String ospId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response oSPOspIdGet(String ospId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response oSPOspIdPrivacyPolicyAccessReasonsGet(String ospId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response oSPOspIdPrivacyPolicyAccessReasonsPost(String ospId, AccessReason ospPolicy, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response oSPOspIdPrivacyPolicyAccessReasonsReasonIdDelete(String ospId, String reasonId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response oSPOspIdPrivacyPolicyAccessReasonsReasonIdPut(String ospId, String reasonId, AccessReason ospPolicy, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response oSPOspIdPrivacyPolicyGet(String ospId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response oSPOspIdPrivacyPolicyPut(String ospId, OSPReasonPolicyInput ospPolicy, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response oSPOspIdPut(String ospId, OSPPrivacyPolicyInput ospPolicy, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response oSPPost(OSPPrivacyPolicyInput ospPolicy, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
     */
}
