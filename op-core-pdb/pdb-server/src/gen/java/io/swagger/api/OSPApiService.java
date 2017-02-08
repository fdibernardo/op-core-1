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
//      Created Date :          2016-10-28
//      Created for Project :   OPERANDO
//
/////////////////////////////////////////////////////////////////////////

package io.swagger.api;

import eu.operando.core.pdb.common.model.AccessReason;
import eu.operando.core.pdb.common.model.OSPReasonPolicyInput;
import eu.operando.core.pdb.common.model.OSPPrivacyPolicyInput;

import io.swagger.api.NotFoundException;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-19T10:59:55.638Z")
public abstract class OSPApiService {
    public abstract Response oSPGet(String filter,SecurityContext securityContext) throws NotFoundException;
    public abstract Response oSPOspIdDelete(String ospId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response oSPOspIdGet(String ospId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response oSPOspIdPrivacyPolicyAccessReasonsGet(String ospId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response oSPOspIdPrivacyPolicyAccessReasonsPost(String ospId,AccessReason ospPolicy,SecurityContext securityContext) throws NotFoundException;
    public abstract Response oSPOspIdPrivacyPolicyAccessReasonsReasonIdDelete(String ospId,String reasonId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response oSPOspIdPrivacyPolicyAccessReasonsReasonIdPut(String ospId,String reasonId,AccessReason ospPolicy,SecurityContext securityContext) throws NotFoundException;
    public abstract Response oSPOspIdPrivacyPolicyGet(String ospId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response oSPOspIdPrivacyPolicyPut(String ospId,OSPReasonPolicyInput ospPolicy,SecurityContext securityContext) throws NotFoundException;
    public abstract Response oSPOspIdPut(String ospId,OSPPrivacyPolicyInput ospPolicy,SecurityContext securityContext) throws NotFoundException;
    public abstract Response oSPPost(OSPPrivacyPolicyInput ospPolicy,SecurityContext securityContext) throws NotFoundException;
}
