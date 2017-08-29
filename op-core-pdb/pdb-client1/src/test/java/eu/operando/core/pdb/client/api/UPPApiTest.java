/**
 * Policy DB
 * The Policy Database that stores three types of documents in dedicated collections.   1) User Privacy Policy. Each OPERANDO user has one UPP document describing their privacy policies for each of the OSP services they are subscribed to. The UPP contains the current B2C privacy settings for a subscribed to OSP. The UPP contains the users privacy preferences. The UPP contains the G2C access policies for the OSP with justification for access.   2) The legislation policies. The regulations entered into OPERANDO using the OPERANDO regulation API.   3) The OSP descriptions and data requests. For each OSP its privacy policy, its access control rules, and the data it requests (as a workflow). For B2C, the set of privacy settings is stored. 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: support@operando.eu
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package eu.operando.core.pdb.client.api;

import eu.operando.core.pdb.client.api.UPPApi;
import eu.operando.core.pdb.client.ApiException;
import eu.operando.core.pdb.client.model.UserPrivacyPolicy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UPPApi
 */
public class UPPApiTest {

    private final UPPApi api = new UPPApi();

    
    /**
     * Perform a search query across the collection of UPPs.
     *
     * The query contains a json object (names, values) and the request returns the list of documents (UPPs) where the filter matches i.e. each document contains fields with those values. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void userPrivacyPolicyGetTest() throws ApiException {
        String filter = null;
        // List<UserPrivacyPolicy> response = api.userPrivacyPolicyGet(filter);

        // TODO: test validations
    }
    
    /**
     * Create a new UPP entry in the database for the user.
     *
     * Called when a new user is registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void userPrivacyPolicyPostTest() throws ApiException {
        UserPrivacyPolicy upp = null;
        // api.userPrivacyPolicyPost(upp);

        // TODO: test validations
    }
    
    /**
     * Remove the UPP entry in the database for the user.
     *
     * Called when a user leaves operando. Their privacy preferences and policies are deleted from the database. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void userPrivacyPolicyUserIdDeleteTest() throws ApiException {
        String userId = null;
        // api.userPrivacyPolicyUserIdDelete(userId);

        // TODO: test validations
    }
    
    /**
     * Read the user privacy policy for the given user id.
     *
     * Get a specific UPP document via the user&#39;s id. This will return the full user privacy policy document in json format. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void userPrivacyPolicyUserIdGetTest() throws ApiException {
        String userId = null;
        // UserPrivacyPolicy response = api.userPrivacyPolicyUserIdGet(userId);

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
        // api.userPrivacyPolicyUserIdPut(userId, upp);

        // TODO: test validations
    }
    
}
