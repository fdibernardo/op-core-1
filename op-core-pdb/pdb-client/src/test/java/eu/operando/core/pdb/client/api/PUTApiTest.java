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
//      Created Date :          2017-03-21
//      Created for Project :   OPERANDO
//
/////////////////////////////////////////////////////////////////////////

/*
 * Policy DB
 * The Policy Database that stores three types of documents in dedicated collections.   1) User Privacy Policy. Each OPERANDO user has one UPP document describing their privacy policies for each of the OSP services they are subscribed to. The UPP contains the current B2C privacy settings for a subscribed to OSP. The UPP contains the users privacy preferences. The UPP contains the G2C access policies for the OSP with justification for access.   2) The legislation policies. The regulations entered into OPERANDO using the OPERANDO regulation API.   3) The OSP descriptions and data requests. For each OSP its privacy policy, its access control rules, and the data it requests (as a workflow). For B2C, the set of privacy settings is stored. 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: support@operando.eu
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package eu.operando.core.pdb.client.api;

import eu.operando.core.pdb.client.api.PUTApi;
import eu.operando.core.pdb.client.ApiException;
import eu.operando.core.pdb.common.model.OSPPrivacyPolicyInput;
import eu.operando.core.pdb.common.model.OSPReasonPolicyInput;
import eu.operando.core.pdb.common.model.PrivacyRegulationInput;
import eu.operando.core.pdb.common.model.UserPrivacyPolicy;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PUTApi
 */
@Ignore
public class PUTApiTest {

    private final PUTApi api = new PUTApi();

    
    /**
     * Update OSP text policy entry in the database.
     *
     * Called when by the watchdog detects a change in the textual policy and wants to update the current policy. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void oSPOspIdPrivacyPolicyPutTest() throws ApiException {
        String ospId = null;
        OSPReasonPolicyInput ospPolicy = null;
        api.oSPOspIdPrivacyPolicyPut(ospId, ospPolicy);

        // TODO: test validations
    }
    
    /**
     * Update OSPBehaviour entry in the database.
     *
     * Called when by the policy computation component when the regulator api updates a regulation. Their new OSPRequest document is stored in the policy DB. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void oSPOspIdPutTest() throws ApiException {
        String ospId = null;
        OSPPrivacyPolicyInput ospPolicy = null;
        api.oSPOspIdPut(ospId, ospPolicy);

        // TODO: test validations
    }
    
    /**
     * Update PrivacyRegulation entry in the database.
     *
     * Called when by the policy computation component when the regulator api updates a regulation. Their new PrivacyRegulation document is stored in the policy DB. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void regulationsRegIdPutTest() throws ApiException {
        String regId = null;
        PrivacyRegulationInput regulation = null;
        api.regulationsRegIdPut(regId, regulation);

        // TODO: test validations
    }
    
    /**
     * Update UPP entry in the database for the user.
     *
     * Called when a user makes a change to the UPP registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void userPrivacyPolicyUserIdPutTest() throws ApiException {
        String userId = null;
        UserPrivacyPolicy upp = null;
        api.userPrivacyPolicyUserIdPut(userId, upp);

        // TODO: test validations
    }
    
}
