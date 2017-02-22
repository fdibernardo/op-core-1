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


import eu.operando.core.pdb.common.model.UserPrivacyPolicy;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UPPApi {
    private ApiClient apiClient;

    public UPPApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UPPApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for userPrivacyPolicyGet */
    private com.squareup.okhttp.Call userPrivacyPolicyGetCall(String filter, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/user_privacy_policy/".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (filter != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filter", filter));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call userPrivacyPolicyGetValidateBeforeCall(String filter, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'filter' is set
        if (filter == null) {
            throw new ApiException("Missing the required parameter 'filter' when calling userPrivacyPolicyGet(Async)");
        }
        
        
        com.squareup.okhttp.Call call = userPrivacyPolicyGetCall(filter, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Perform a search query across the collection of UPPs.
     * The query contains a json object (names, values) and the request returns the list of documents (UPPs) where the filter matches i.e. each document contains fields with those values. 
     * @param filter The query filter to be matched - ?filter&#x3D;{json description} (required)
     * @return List&lt;UserPrivacyPolicy&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<UserPrivacyPolicy> userPrivacyPolicyGet(String filter) throws ApiException {
        ApiResponse<List<UserPrivacyPolicy>> resp = userPrivacyPolicyGetWithHttpInfo(filter);
        return resp.getData();
    }

    /**
     * Perform a search query across the collection of UPPs.
     * The query contains a json object (names, values) and the request returns the list of documents (UPPs) where the filter matches i.e. each document contains fields with those values. 
     * @param filter The query filter to be matched - ?filter&#x3D;{json description} (required)
     * @return ApiResponse&lt;List&lt;UserPrivacyPolicy&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<UserPrivacyPolicy>> userPrivacyPolicyGetWithHttpInfo(String filter) throws ApiException {
        com.squareup.okhttp.Call call = userPrivacyPolicyGetValidateBeforeCall(filter, null, null);
        Type localVarReturnType = new TypeToken<List<UserPrivacyPolicy>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Perform a search query across the collection of UPPs. (asynchronously)
     * The query contains a json object (names, values) and the request returns the list of documents (UPPs) where the filter matches i.e. each document contains fields with those values. 
     * @param filter The query filter to be matched - ?filter&#x3D;{json description} (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call userPrivacyPolicyGetAsync(String filter, final ApiCallback<List<UserPrivacyPolicy>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = userPrivacyPolicyGetValidateBeforeCall(filter, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<UserPrivacyPolicy>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for userPrivacyPolicyPost */
    private com.squareup.okhttp.Call userPrivacyPolicyPostCall(UserPrivacyPolicy upp, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = upp;
        
        // create path and map variables
        String localVarPath = "/user_privacy_policy/".replaceAll("\\{format\\}","json");

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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call userPrivacyPolicyPostValidateBeforeCall(UserPrivacyPolicy upp, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'upp' is set
        if (upp == null) {
            throw new ApiException("Missing the required parameter 'upp' when calling userPrivacyPolicyPost(Async)");
        }
        
        
        com.squareup.okhttp.Call call = userPrivacyPolicyPostCall(upp, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create a new UPP entry in the database for the user.
     * Called when a new user is registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
     * @param upp The first instance of this user&#39;s UPP (required)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public String userPrivacyPolicyPost(UserPrivacyPolicy upp) throws ApiException {
        ApiResponse<String> resp = userPrivacyPolicyPostWithHttpInfo(upp);
        return resp.getData();
    }

    /**
     * Create a new UPP entry in the database for the user.
     * Called when a new user is registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
     * @param upp The first instance of this user&#39;s UPP (required)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<String> userPrivacyPolicyPostWithHttpInfo(UserPrivacyPolicy upp) throws ApiException {
        com.squareup.okhttp.Call call = userPrivacyPolicyPostValidateBeforeCall(upp, null, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new UPP entry in the database for the user. (asynchronously)
     * Called when a new user is registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
     * @param upp The first instance of this user&#39;s UPP (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call userPrivacyPolicyPostAsync(UserPrivacyPolicy upp, final ApiCallback<String> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = userPrivacyPolicyPostValidateBeforeCall(upp, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
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
    /* Build call for userPrivacyPolicyUserIdGet */
    private com.squareup.okhttp.Call userPrivacyPolicyUserIdGetCall(String userId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call userPrivacyPolicyUserIdGetValidateBeforeCall(String userId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling userPrivacyPolicyUserIdGet(Async)");
        }
        
        
        com.squareup.okhttp.Call call = userPrivacyPolicyUserIdGetCall(userId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Read the user privacy policy for the given user id.
     * Get a specific UPP document via the user&#39;s id. This will return the full user privacy policy document in json format. 
     * @param userId The user identifier number (required)
     * @return UserPrivacyPolicy
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UserPrivacyPolicy userPrivacyPolicyUserIdGet(String userId) throws ApiException {
        ApiResponse<UserPrivacyPolicy> resp = userPrivacyPolicyUserIdGetWithHttpInfo(userId);
        return resp.getData();
    }

    /**
     * Read the user privacy policy for the given user id.
     * Get a specific UPP document via the user&#39;s id. This will return the full user privacy policy document in json format. 
     * @param userId The user identifier number (required)
     * @return ApiResponse&lt;UserPrivacyPolicy&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UserPrivacyPolicy> userPrivacyPolicyUserIdGetWithHttpInfo(String userId) throws ApiException {
        com.squareup.okhttp.Call call = userPrivacyPolicyUserIdGetValidateBeforeCall(userId, null, null);
        Type localVarReturnType = new TypeToken<UserPrivacyPolicy>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Read the user privacy policy for the given user id. (asynchronously)
     * Get a specific UPP document via the user&#39;s id. This will return the full user privacy policy document in json format. 
     * @param userId The user identifier number (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call userPrivacyPolicyUserIdGetAsync(String userId, final ApiCallback<UserPrivacyPolicy> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = userPrivacyPolicyUserIdGetValidateBeforeCall(userId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UserPrivacyPolicy>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for userPrivacyPolicyUserIdPut */
    private com.squareup.okhttp.Call userPrivacyPolicyUserIdPutCall(String userId, UserPrivacyPolicy upp, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = upp;
        
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call userPrivacyPolicyUserIdPutValidateBeforeCall(String userId, UserPrivacyPolicy upp, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling userPrivacyPolicyUserIdPut(Async)");
        }
        
        // verify the required parameter 'upp' is set
        if (upp == null) {
            throw new ApiException("Missing the required parameter 'upp' when calling userPrivacyPolicyUserIdPut(Async)");
        }
        
        
        com.squareup.okhttp.Call call = userPrivacyPolicyUserIdPutCall(userId, upp, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update UPP entry in the database for the user.
     * Called when a user makes a change to the UPP registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
     * @param userId The user identifier number (required)
     * @param upp The changed instance of this user&#39;s UPP (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void userPrivacyPolicyUserIdPut(String userId, UserPrivacyPolicy upp) throws ApiException {
        userPrivacyPolicyUserIdPutWithHttpInfo(userId, upp);
    }

    /**
     * Update UPP entry in the database for the user.
     * Called when a user makes a change to the UPP registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
     * @param userId The user identifier number (required)
     * @param upp The changed instance of this user&#39;s UPP (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> userPrivacyPolicyUserIdPutWithHttpInfo(String userId, UserPrivacyPolicy upp) throws ApiException {
        com.squareup.okhttp.Call call = userPrivacyPolicyUserIdPutValidateBeforeCall(userId, upp, null, null);
        return apiClient.execute(call);
    }

    /**
     * Update UPP entry in the database for the user. (asynchronously)
     * Called when a user makes a change to the UPP registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
     * @param userId The user identifier number (required)
     * @param upp The changed instance of this user&#39;s UPP (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call userPrivacyPolicyUserIdPutAsync(String userId, UserPrivacyPolicy upp, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = userPrivacyPolicyUserIdPutValidateBeforeCall(userId, upp, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}
