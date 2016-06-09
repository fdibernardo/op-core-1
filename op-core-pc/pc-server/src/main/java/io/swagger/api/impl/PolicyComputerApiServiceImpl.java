/////////////////////////////////////////////////////////////////////////
//
// � University of Southampton IT Innovation Centre, 2016
//
// Copyright in this library belongs to the University of Southampton
// University Road, Highfield, Southampton, UK, SO17 1BJ
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
// Created By : Paul Grace
// Created for Project : OPERANDO (http://www.operando.eu)
//
/////////////////////////////////////////////////////////////////////////
//
//  License : GNU Lesser General Public License, version 3
//
/////////////////////////////////////////////////////////////////////////
package io.swagger.api.impl;

import eu.operando.InvalidPreferenceException;
import eu.operando.PolicyComputerService;
import eu.operando.UnknownUserException;
import io.swagger.api.*;
import io.swagger.model.UserPreference;

import java.util.List;
import io.swagger.api.NotFoundException;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-05-13T11:11:54.739Z")
public class PolicyComputerApiServiceImpl extends PolicyComputerApiService {

    @Override
    public Response policyComputerPost(String userId, List<UserPreference> generalPreferences, SecurityContext securityContext)
    throws NotFoundException {

        try {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK,
                    PolicyComputerService.computeNewPolicy(userId, generalPreferences))).build();
        } catch (UnknownUserException ex) {
            throw new NotFoundException(400, "Client error");
        } catch (InvalidPreferenceException ex) {
            throw new NotFoundException(400, "Client error");
        }
    }
}