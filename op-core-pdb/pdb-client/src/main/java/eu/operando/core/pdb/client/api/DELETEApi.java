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

import eu.operando.core.pdb.client.ApiCallback;
import eu.operando.core.pdb.client.ApiClient;
import eu.operando.core.pdb.client.ApiException;
import eu.operando.core.pdb.client.ApiResponse;
import eu.operando.core.pdb.client.Configuration;
import eu.operando.core.pdb.client.Pair;
import eu.operando.core.pdb.client.ProgressRequestBody;
import eu.operando.core.pdb.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;



import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DELETEApi {
    private ApiClient apiClient;

    public DELETEApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DELETEApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for oSPOspIdDelete */
    private com.squareup.okhttp.Call oSPOspIdDeleteCall(String ospId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/OSP/{osp-id}/".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "osp-id" + "\\}", apiClient.escapeString(ospId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call oSPOspIdDeleteValidateBeforeCall(String ospId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'ospId' is set
        if (ospId == null) {
            throw new ApiException("Missing the required parameter 'ospId' when calling oSPOspIdDelete(Async)");
        }
        
        
        com.squareup.okhttp.Call call = oSPOspIdDeleteCall(ospId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Remove the OSPRequest entry in the database.
     * Called when by the policy computation component when the regulator api requests that the regulation be deleted. 
     * @param ospId The identifier number of an OSP (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void oSPOspIdDelete(String ospId) throws ApiException {
        oSPOspIdDeleteWithHttpInfo(ospId);
    }

    /**
     * Remove the OSPRequest entry in the database.
     * Called when by the policy computation component when the regulator api requests that the regulation be deleted. 
     * @param ospId The identifier number of an OSP (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> oSPOspIdDeleteWithHttpInfo(String ospId) throws ApiException {
        com.squareup.okhttp.Call call = oSPOspIdDeleteValidateBeforeCall(ospId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Remove the OSPRequest entry in the database. (asynchronously)
     * Called when by the policy computation component when the regulator api requests that the regulation be deleted. 
     * @param ospId The identifier number of an OSP (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call oSPOspIdDeleteAsync(String ospId, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = oSPOspIdDeleteValidateBeforeCall(ospId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for oSPOspIdPrivacyPolicyAccessReasonsReasonIdDelete */
    private com.squareup.okhttp.Call oSPOspIdPrivacyPolicyAccessReasonsReasonIdDeleteCall(String ospId, String reasonId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/OSP/{osp-id}/privacy-policy/access-reasons/{reason-id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "osp-id" + "\\}", apiClient.escapeString(ospId.toString()))
        .replaceAll("\\{" + "reason-id" + "\\}", apiClient.escapeString(reasonId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call oSPOspIdPrivacyPolicyAccessReasonsReasonIdDeleteValidateBeforeCall(String ospId, String reasonId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'ospId' is set
        if (ospId == null) {
            throw new ApiException("Missing the required parameter 'ospId' when calling oSPOspIdPrivacyPolicyAccessReasonsReasonIdDelete(Async)");
        }
        
        // verify the required parameter 'reasonId' is set
        if (reasonId == null) {
            throw new ApiException("Missing the required parameter 'reasonId' when calling oSPOspIdPrivacyPolicyAccessReasonsReasonIdDelete(Async)");
        }
        
        
        com.squareup.okhttp.Call call = oSPOspIdPrivacyPolicyAccessReasonsReasonIdDeleteCall(ospId, reasonId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Remove the AccessReason entry in the list.
     * Remove an identified value. 
     * @param ospId The identifier number of an OSP (required)
     * @param reasonId The identifier of a statement in a policy, is only unique to the policy. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void oSPOspIdPrivacyPolicyAccessReasonsReasonIdDelete(String ospId, String reasonId) throws ApiException {
        oSPOspIdPrivacyPolicyAccessReasonsReasonIdDeleteWithHttpInfo(ospId, reasonId);
    }

    /**
     * Remove the AccessReason entry in the list.
     * Remove an identified value. 
     * @param ospId The identifier number of an OSP (required)
     * @param reasonId The identifier of a statement in a policy, is only unique to the policy. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> oSPOspIdPrivacyPolicyAccessReasonsReasonIdDeleteWithHttpInfo(String ospId, String reasonId) throws ApiException {
        com.squareup.okhttp.Call call = oSPOspIdPrivacyPolicyAccessReasonsReasonIdDeleteValidateBeforeCall(ospId, reasonId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Remove the AccessReason entry in the list. (asynchronously)
     * Remove an identified value. 
     * @param ospId The identifier number of an OSP (required)
     * @param reasonId The identifier of a statement in a policy, is only unique to the policy. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call oSPOspIdPrivacyPolicyAccessReasonsReasonIdDeleteAsync(String ospId, String reasonId, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = oSPOspIdPrivacyPolicyAccessReasonsReasonIdDeleteValidateBeforeCall(ospId, reasonId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for regulationsRegIdDelete */
    private com.squareup.okhttp.Call regulationsRegIdDeleteCall(String regId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/regulations/{reg-id}/".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "reg-id" + "\\}", apiClient.escapeString(regId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call regulationsRegIdDeleteValidateBeforeCall(String regId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'regId' is set
        if (regId == null) {
            throw new ApiException("Missing the required parameter 'regId' when calling regulationsRegIdDelete(Async)");
        }
        
        
        com.squareup.okhttp.Call call = regulationsRegIdDeleteCall(regId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Remove the PrivacyRegulation entry in the database.
     * Called when by the policy computation component when the regulator api requests that the regulation be deleted. 
     * @param regId The identifier number of a regulation (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void regulationsRegIdDelete(String regId) throws ApiException {
        regulationsRegIdDeleteWithHttpInfo(regId);
    }

    /**
     * Remove the PrivacyRegulation entry in the database.
     * Called when by the policy computation component when the regulator api requests that the regulation be deleted. 
     * @param regId The identifier number of a regulation (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> regulationsRegIdDeleteWithHttpInfo(String regId) throws ApiException {
        com.squareup.okhttp.Call call = regulationsRegIdDeleteValidateBeforeCall(regId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Remove the PrivacyRegulation entry in the database. (asynchronously)
     * Called when by the policy computation component when the regulator api requests that the regulation be deleted. 
     * @param regId The identifier number of a regulation (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call regulationsRegIdDeleteAsync(String regId, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = regulationsRegIdDeleteValidateBeforeCall(regId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for userPrivacyPolicyUserIdDelete */
    private com.squareup.okhttp.Call userPrivacyPolicyUserIdDeleteCall(String userId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/user_privacy_policy/{user-id}/".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "user-id" + "\\}", apiClient.escapeString(userId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call userPrivacyPolicyUserIdDeleteValidateBeforeCall(String userId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling userPrivacyPolicyUserIdDelete(Async)");
        }
        
        
        com.squareup.okhttp.Call call = userPrivacyPolicyUserIdDeleteCall(userId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Remove the UPP entry in the database for the user.
     * Called when a user leaves operando. Their privacy preferences and policies are deleted from the database. 
     * @param userId The user identifier number (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void userPrivacyPolicyUserIdDelete(String userId) throws ApiException {
        userPrivacyPolicyUserIdDeleteWithHttpInfo(userId);
    }

    /**
     * Remove the UPP entry in the database for the user.
     * Called when a user leaves operando. Their privacy preferences and policies are deleted from the database. 
     * @param userId The user identifier number (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> userPrivacyPolicyUserIdDeleteWithHttpInfo(String userId) throws ApiException {
        com.squareup.okhttp.Call call = userPrivacyPolicyUserIdDeleteValidateBeforeCall(userId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Remove the UPP entry in the database for the user. (asynchronously)
     * Called when a user leaves operando. Their privacy preferences and policies are deleted from the database. 
     * @param userId The user identifier number (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call userPrivacyPolicyUserIdDeleteAsync(String userId, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = userPrivacyPolicyUserIdDeleteValidateBeforeCall(userId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}
