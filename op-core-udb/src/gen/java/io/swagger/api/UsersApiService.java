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
//      Created By :            Panos Melas/Paul Grace
//      Created Date :          2016-10-28
//      Created for Project :   OPERANDO
//
/////////////////////////////////////////////////////////////////////////
package io.swagger.api;


import io.swagger.model.UserAccount;

import io.swagger.api.NotFoundException;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-10T09:30:45.275Z")
public abstract class UsersApiService {
    public abstract Response usersPost(UserAccount user,SecurityContext securityContext) throws NotFoundException;
    public abstract Response usersUserIdDelete(String userId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response usersUserIdGet(String userId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response usersUserIdPut(String userId,UserAccount upp,SecurityContext securityContext) throws NotFoundException;
}