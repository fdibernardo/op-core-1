/*
   	* Copyright (c) 2017 {TECNALIA}.
    * All rights reserved. This program and the accompanying materials
    * are made available under the terms of the The MIT License (MIT).
    * which accompanies this distribution, and is available at
    * http://opensource.org/licenses/MIT
    *
    * Contributors:
    *    Gorka Benguria Elguezabal {TECNALIA}
    *    Gorka Mikel Echevarría {TECNALIA}
    * Initially developed in the context of OPERANDO EU project www.operando.eu
 */
package io.swagger.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.annotations.ApiParam;
import io.swagger.api.factories.LogApiServiceFactory;
import io.swagger.model.LogRequest;
import io.swagger.model.LogRequestTicket;
@Path("/log")

@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the log API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-05-16T12:28:19.935Z")
public class LogApi  {
   private final LogApiService delegate = LogApiServiceFactory.getLogApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Inserts received data to the database.", notes = "Inserts received data to the database by using Log4j.", response = String.class, tags={ "Log" })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class),
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
    public Response log(
        @ApiParam(value = "The request data in JSON format to be inserted in the database by using Log4j" ,required=true) LogRequest request,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.log(request,securityContext);
    }
    
    @POST
    @Path("/logTicket")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Inserts received data to the database.", notes = "Inserts received data to the database by using Log4j.", response = void.class, authorizations = {
            //@io.swagger.annotations.Authorization(value = "osp-identifier"),
            //@io.swagger.annotations.Authorization(value = "psp-user-identifier"),
            @io.swagger.annotations.Authorization(value = "service-ticket")
        }, tags={ "Log", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Succesful operation. ", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "The client inputs to the operation are incorrect or invalid. The caller should check the inputs are valid based upon the returned error message. ", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Error. The service ticket failed to validate. ", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 415, message = "The operation consumes json messages. Please, check that the sent message is in json format. ", response = void.class) })
    public Response logTicket(@ApiParam(value = "The request data in JSON format to be inserted in the database by using Log4j" ,required=true) LogRequestTicket request
,@Context SecurityContext securityContext,@Context HttpHeaders headers)
    throws NotFoundException {
        return delegate.logTicket(request,securityContext,headers);
    }
}
