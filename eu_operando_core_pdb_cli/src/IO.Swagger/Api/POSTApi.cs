/* 
 * Policy DB
 *
 * The Policy Database that stores three types of documents in dedicated collections.   1) User Privacy Policy. Each OPERANDO user has one UPP document describing their privacy policies for each of the OSP services they are subscribed to. The UPP contains the current B2C privacy settings for a subscribed to OSP. The UPP contains the users privacy preferences. The UPP contains the G2C access policies for the OSP with justification for access.   2) The legislation policies. The regulations entered into OPERANDO using the OPERANDO regulation API.   3) The OSP descriptions and data requests. For each OSP its privacy policy, its access control rules, and the data it requests (as a workflow). For B2C, the set of privacy settings is stored. 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: support@operando.eu
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using RestSharp;
using eu.operando.core.pdb.cli.Client;
using eu.operando.core.pdb.cli.Model;

namespace eu.operando.core.pdb.cli.Api
{
    /// <summary>
    /// Represents a collection of functions to interact with the API endpoints
    /// </summary>
    public interface IPOSTApi : IApiAccessor
    {
        #region Synchronous Operations
        /// <summary>
        /// Create a new OSP entry in the database.
        /// </summary>
        /// <remarks>
        /// Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </remarks>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="ospPolicy">The first instance of this OSP document</param>
        /// <returns></returns>
        void OSPPost (OSPPrivacyPolicyInput ospPolicy);

        /// <summary>
        /// Create a new OSP entry in the database.
        /// </summary>
        /// <remarks>
        /// Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </remarks>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="ospPolicy">The first instance of this OSP document</param>
        /// <returns>ApiResponse of Object(void)</returns>
        ApiResponse<Object> OSPPostWithHttpInfo (OSPPrivacyPolicyInput ospPolicy);
        /// <summary>
        /// Create a new legislation entry in the database.
        /// </summary>
        /// <remarks>
        /// Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </remarks>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="regulation">The first instance of this regulation document</param>
        /// <returns>PrivacyRegulation</returns>
        PrivacyRegulation RegulationsPost (PrivacyRegulationInput regulation);

        /// <summary>
        /// Create a new legislation entry in the database.
        /// </summary>
        /// <remarks>
        /// Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </remarks>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="regulation">The first instance of this regulation document</param>
        /// <returns>ApiResponse of PrivacyRegulation</returns>
        ApiResponse<PrivacyRegulation> RegulationsPostWithHttpInfo (PrivacyRegulationInput regulation);
        /// <summary>
        /// Create a new UPP entry in the database for the user.
        /// </summary>
        /// <remarks>
        /// Called when a new user is registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
        /// </remarks>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="upp">The first instance of this user&#39;s UPP</param>
        /// <returns></returns>
        void UserPrivacyPolicyPost (UserPrivacyPolicy upp);

        /// <summary>
        /// Create a new UPP entry in the database for the user.
        /// </summary>
        /// <remarks>
        /// Called when a new user is registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
        /// </remarks>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="upp">The first instance of this user&#39;s UPP</param>
        /// <returns>ApiResponse of Object(void)</returns>
        ApiResponse<Object> UserPrivacyPolicyPostWithHttpInfo (UserPrivacyPolicy upp);
        #endregion Synchronous Operations
        #region Asynchronous Operations
        /// <summary>
        /// Create a new OSP entry in the database.
        /// </summary>
        /// <remarks>
        /// Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </remarks>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="ospPolicy">The first instance of this OSP document</param>
        /// <returns>Task of void</returns>
        System.Threading.Tasks.Task OSPPostAsync (OSPPrivacyPolicyInput ospPolicy);

        /// <summary>
        /// Create a new OSP entry in the database.
        /// </summary>
        /// <remarks>
        /// Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </remarks>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="ospPolicy">The first instance of this OSP document</param>
        /// <returns>Task of ApiResponse</returns>
        System.Threading.Tasks.Task<ApiResponse<Object>> OSPPostAsyncWithHttpInfo (OSPPrivacyPolicyInput ospPolicy);
        /// <summary>
        /// Create a new legislation entry in the database.
        /// </summary>
        /// <remarks>
        /// Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </remarks>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="regulation">The first instance of this regulation document</param>
        /// <returns>Task of PrivacyRegulation</returns>
        System.Threading.Tasks.Task<PrivacyRegulation> RegulationsPostAsync (PrivacyRegulationInput regulation);

        /// <summary>
        /// Create a new legislation entry in the database.
        /// </summary>
        /// <remarks>
        /// Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </remarks>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="regulation">The first instance of this regulation document</param>
        /// <returns>Task of ApiResponse (PrivacyRegulation)</returns>
        System.Threading.Tasks.Task<ApiResponse<PrivacyRegulation>> RegulationsPostAsyncWithHttpInfo (PrivacyRegulationInput regulation);
        /// <summary>
        /// Create a new UPP entry in the database for the user.
        /// </summary>
        /// <remarks>
        /// Called when a new user is registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
        /// </remarks>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="upp">The first instance of this user&#39;s UPP</param>
        /// <returns>Task of void</returns>
        System.Threading.Tasks.Task UserPrivacyPolicyPostAsync (UserPrivacyPolicy upp);

        /// <summary>
        /// Create a new UPP entry in the database for the user.
        /// </summary>
        /// <remarks>
        /// Called when a new user is registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
        /// </remarks>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="upp">The first instance of this user&#39;s UPP</param>
        /// <returns>Task of ApiResponse</returns>
        System.Threading.Tasks.Task<ApiResponse<Object>> UserPrivacyPolicyPostAsyncWithHttpInfo (UserPrivacyPolicy upp);
        #endregion Asynchronous Operations
    }

    /// <summary>
    /// Represents a collection of functions to interact with the API endpoints
    /// </summary>
    public partial class POSTApi : IPOSTApi
    {
        private eu.operando.core.pdb.cli.Client.ExceptionFactory _exceptionFactory = (name, response) => null;

        /// <summary>
        /// Initializes a new instance of the <see cref="POSTApi"/> class.
        /// </summary>
        /// <returns></returns>
        public POSTApi(String basePath)
        {
            this.Configuration = new Configuration(new ApiClient(basePath));

            ExceptionFactory = eu.operando.core.pdb.cli.Client.Configuration.DefaultExceptionFactory;

            // ensure API client has configuration ready
            if (Configuration.ApiClient.Configuration == null)
            {
                this.Configuration.ApiClient.Configuration = this.Configuration;
            }
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="POSTApi"/> class
        /// using Configuration object
        /// </summary>
        /// <param name="configuration">An instance of Configuration</param>
        /// <returns></returns>
        public POSTApi(Configuration configuration = null)
        {
            if (configuration == null) // use the default one in Configuration
                this.Configuration = Configuration.Default;
            else
                this.Configuration = configuration;

            ExceptionFactory = eu.operando.core.pdb.cli.Client.Configuration.DefaultExceptionFactory;

            // ensure API client has configuration ready
            if (Configuration.ApiClient.Configuration == null)
            {
                this.Configuration.ApiClient.Configuration = this.Configuration;
            }
        }

        /// <summary>
        /// Gets the base path of the API client.
        /// </summary>
        /// <value>The base path</value>
        public String GetBasePath()
        {
            return this.Configuration.ApiClient.RestClient.BaseUrl.ToString();
        }

        /// <summary>
        /// Sets the base path of the API client.
        /// </summary>
        /// <value>The base path</value>
        [Obsolete("SetBasePath is deprecated, please do 'Configuration.ApiClient = new ApiClient(\"http://new-path\")' instead.")]
        public void SetBasePath(String basePath)
        {
            // do nothing
        }

        /// <summary>
        /// Gets or sets the configuration object
        /// </summary>
        /// <value>An instance of the Configuration</value>
        public Configuration Configuration {get; set;}

        /// <summary>
        /// Provides a factory method hook for the creation of exceptions.
        /// </summary>
        public eu.operando.core.pdb.cli.Client.ExceptionFactory ExceptionFactory
        {
            get
            {
                if (_exceptionFactory != null && _exceptionFactory.GetInvocationList().Length > 1)
                {
                    throw new InvalidOperationException("Multicast delegate for ExceptionFactory is unsupported.");
                }
                return _exceptionFactory;
            }
            set { _exceptionFactory = value; }
        }

        /// <summary>
        /// Gets the default header.
        /// </summary>
        /// <returns>Dictionary of HTTP header</returns>
        [Obsolete("DefaultHeader is deprecated, please use Configuration.DefaultHeader instead.")]
        public Dictionary<String, String> DefaultHeader()
        {
            return this.Configuration.DefaultHeader;
        }

        /// <summary>
        /// Add default header.
        /// </summary>
        /// <param name="key">Header field name.</param>
        /// <param name="value">Header field value.</param>
        /// <returns></returns>
        [Obsolete("AddDefaultHeader is deprecated, please use Configuration.AddDefaultHeader instead.")]
        public void AddDefaultHeader(string key, string value)
        {
            this.Configuration.AddDefaultHeader(key, value);
        }

        /// <summary>
        /// Create a new OSP entry in the database. Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </summary>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="ospPolicy">The first instance of this OSP document</param>
        /// <returns></returns>
        public void OSPPost (OSPPrivacyPolicyInput ospPolicy)
        {
             OSPPostWithHttpInfo(ospPolicy);
        }

        /// <summary>
        /// Create a new OSP entry in the database. Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </summary>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="ospPolicy">The first instance of this OSP document</param>
        /// <returns>ApiResponse of Object(void)</returns>
        public ApiResponse<Object> OSPPostWithHttpInfo (OSPPrivacyPolicyInput ospPolicy)
        {
            // verify the required parameter 'ospPolicy' is set
            if (ospPolicy == null)
                throw new ApiException(400, "Missing required parameter 'ospPolicy' when calling POSTApi->OSPPost");

            var localVarPath = "/OSP/";
            var localVarPathParams = new Dictionary<String, String>();
            var localVarQueryParams = new Dictionary<String, String>();
            var localVarHeaderParams = new Dictionary<String, String>(Configuration.DefaultHeader);
            var localVarFormParams = new Dictionary<String, String>();
            var localVarFileParams = new Dictionary<String, FileParameter>();
            Object localVarPostBody = null;

            // to determine the Content-Type header
            String[] localVarHttpContentTypes = new String[] {
            };
            String localVarHttpContentType = Configuration.ApiClient.SelectHeaderContentType(localVarHttpContentTypes);

            // to determine the Accept header
            String[] localVarHttpHeaderAccepts = new String[] {
            };
            String localVarHttpHeaderAccept = Configuration.ApiClient.SelectHeaderAccept(localVarHttpHeaderAccepts);
            if (localVarHttpHeaderAccept != null)
                localVarHeaderParams.Add("Accept", localVarHttpHeaderAccept);

            // set "format" to json by default
            // e.g. /pet/{petId}.{format} becomes /pet/{petId}.json
            localVarPathParams.Add("format", "json");
            if (ospPolicy != null && ospPolicy.GetType() != typeof(byte[]))
            {
                localVarPostBody = Configuration.ApiClient.Serialize(ospPolicy); // http body (model) parameter
            }
            else
            {
                localVarPostBody = ospPolicy; // byte array
            }


            // make the HTTP request
            IRestResponse localVarResponse = (IRestResponse) Configuration.ApiClient.CallApi(localVarPath,
                Method.POST, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarFileParams,
                localVarPathParams, localVarHttpContentType);

            int localVarStatusCode = (int) localVarResponse.StatusCode;

            if (ExceptionFactory != null)
            {
                Exception exception = ExceptionFactory("OSPPost", localVarResponse);
                if (exception != null) throw exception;
            }

            
            return new ApiResponse<Object>(localVarStatusCode,
                localVarResponse.Headers.ToDictionary(x => x.Name, x => x.Value.ToString()),
                null);
        }

        /// <summary>
        /// Create a new OSP entry in the database. Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </summary>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="ospPolicy">The first instance of this OSP document</param>
        /// <returns>Task of void</returns>
        public async System.Threading.Tasks.Task OSPPostAsync (OSPPrivacyPolicyInput ospPolicy)
        {
             await OSPPostAsyncWithHttpInfo(ospPolicy);

        }

        /// <summary>
        /// Create a new OSP entry in the database. Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </summary>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="ospPolicy">The first instance of this OSP document</param>
        /// <returns>Task of ApiResponse</returns>
        public async System.Threading.Tasks.Task<ApiResponse<Object>> OSPPostAsyncWithHttpInfo (OSPPrivacyPolicyInput ospPolicy)
        {
            // verify the required parameter 'ospPolicy' is set
            if (ospPolicy == null)
                throw new ApiException(400, "Missing required parameter 'ospPolicy' when calling POSTApi->OSPPost");

            var localVarPath = "/OSP/";
            var localVarPathParams = new Dictionary<String, String>();
            var localVarQueryParams = new Dictionary<String, String>();
            var localVarHeaderParams = new Dictionary<String, String>(Configuration.DefaultHeader);
            var localVarFormParams = new Dictionary<String, String>();
            var localVarFileParams = new Dictionary<String, FileParameter>();
            Object localVarPostBody = null;

            // to determine the Content-Type header
            String[] localVarHttpContentTypes = new String[] {
            };
            String localVarHttpContentType = Configuration.ApiClient.SelectHeaderContentType(localVarHttpContentTypes);

            // to determine the Accept header
            String[] localVarHttpHeaderAccepts = new String[] {
            };
            String localVarHttpHeaderAccept = Configuration.ApiClient.SelectHeaderAccept(localVarHttpHeaderAccepts);
            if (localVarHttpHeaderAccept != null)
                localVarHeaderParams.Add("Accept", localVarHttpHeaderAccept);

            // set "format" to json by default
            // e.g. /pet/{petId}.{format} becomes /pet/{petId}.json
            localVarPathParams.Add("format", "json");
            if (ospPolicy != null && ospPolicy.GetType() != typeof(byte[]))
            {
                localVarPostBody = Configuration.ApiClient.Serialize(ospPolicy); // http body (model) parameter
            }
            else
            {
                localVarPostBody = ospPolicy; // byte array
            }


            // make the HTTP request
            IRestResponse localVarResponse = (IRestResponse) await Configuration.ApiClient.CallApiAsync(localVarPath,
                Method.POST, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarFileParams,
                localVarPathParams, localVarHttpContentType);

            int localVarStatusCode = (int) localVarResponse.StatusCode;

            if (ExceptionFactory != null)
            {
                Exception exception = ExceptionFactory("OSPPost", localVarResponse);
                if (exception != null) throw exception;
            }

            
            return new ApiResponse<Object>(localVarStatusCode,
                localVarResponse.Headers.ToDictionary(x => x.Name, x => x.Value.ToString()),
                null);
        }

        /// <summary>
        /// Create a new legislation entry in the database. Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </summary>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="regulation">The first instance of this regulation document</param>
        /// <returns>PrivacyRegulation</returns>
        public PrivacyRegulation RegulationsPost (PrivacyRegulationInput regulation)
        {
             ApiResponse<PrivacyRegulation> localVarResponse = RegulationsPostWithHttpInfo(regulation);
             return localVarResponse.Data;
        }

        /// <summary>
        /// Create a new legislation entry in the database. Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </summary>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="regulation">The first instance of this regulation document</param>
        /// <returns>ApiResponse of PrivacyRegulation</returns>
        public ApiResponse< PrivacyRegulation > RegulationsPostWithHttpInfo (PrivacyRegulationInput regulation)
        {
            // verify the required parameter 'regulation' is set
            if (regulation == null)
                throw new ApiException(400, "Missing required parameter 'regulation' when calling POSTApi->RegulationsPost");

            var localVarPath = "/regulations/";
            var localVarPathParams = new Dictionary<String, String>();
            var localVarQueryParams = new Dictionary<String, String>();
            var localVarHeaderParams = new Dictionary<String, String>(Configuration.DefaultHeader);
            var localVarFormParams = new Dictionary<String, String>();
            var localVarFileParams = new Dictionary<String, FileParameter>();
            Object localVarPostBody = null;

            // to determine the Content-Type header
            String[] localVarHttpContentTypes = new String[] {
            };
            String localVarHttpContentType = Configuration.ApiClient.SelectHeaderContentType(localVarHttpContentTypes);

            // to determine the Accept header
            String[] localVarHttpHeaderAccepts = new String[] {
            };
            String localVarHttpHeaderAccept = Configuration.ApiClient.SelectHeaderAccept(localVarHttpHeaderAccepts);
            if (localVarHttpHeaderAccept != null)
                localVarHeaderParams.Add("Accept", localVarHttpHeaderAccept);

            // set "format" to json by default
            // e.g. /pet/{petId}.{format} becomes /pet/{petId}.json
            localVarPathParams.Add("format", "json");
            if (regulation != null && regulation.GetType() != typeof(byte[]))
            {
                localVarPostBody = Configuration.ApiClient.Serialize(regulation); // http body (model) parameter
            }
            else
            {
                localVarPostBody = regulation; // byte array
            }


            // make the HTTP request
            IRestResponse localVarResponse = (IRestResponse) Configuration.ApiClient.CallApi(localVarPath,
                Method.POST, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarFileParams,
                localVarPathParams, localVarHttpContentType);

            int localVarStatusCode = (int) localVarResponse.StatusCode;

            if (ExceptionFactory != null)
            {
                Exception exception = ExceptionFactory("RegulationsPost", localVarResponse);
                if (exception != null) throw exception;
            }

            return new ApiResponse<PrivacyRegulation>(localVarStatusCode,
                localVarResponse.Headers.ToDictionary(x => x.Name, x => x.Value.ToString()),
                (PrivacyRegulation) Configuration.ApiClient.Deserialize(localVarResponse, typeof(PrivacyRegulation)));
            
        }

        /// <summary>
        /// Create a new legislation entry in the database. Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </summary>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="regulation">The first instance of this regulation document</param>
        /// <returns>Task of PrivacyRegulation</returns>
        public async System.Threading.Tasks.Task<PrivacyRegulation> RegulationsPostAsync (PrivacyRegulationInput regulation)
        {
             ApiResponse<PrivacyRegulation> localVarResponse = await RegulationsPostAsyncWithHttpInfo(regulation);
             return localVarResponse.Data;

        }

        /// <summary>
        /// Create a new legislation entry in the database. Called by the policy computation component when a new regulation is added to OPERANDO. 
        /// </summary>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="regulation">The first instance of this regulation document</param>
        /// <returns>Task of ApiResponse (PrivacyRegulation)</returns>
        public async System.Threading.Tasks.Task<ApiResponse<PrivacyRegulation>> RegulationsPostAsyncWithHttpInfo (PrivacyRegulationInput regulation)
        {
            // verify the required parameter 'regulation' is set
            if (regulation == null)
                throw new ApiException(400, "Missing required parameter 'regulation' when calling POSTApi->RegulationsPost");

            var localVarPath = "/regulations/";
            var localVarPathParams = new Dictionary<String, String>();
            var localVarQueryParams = new Dictionary<String, String>();
            var localVarHeaderParams = new Dictionary<String, String>(Configuration.DefaultHeader);
            var localVarFormParams = new Dictionary<String, String>();
            var localVarFileParams = new Dictionary<String, FileParameter>();
            Object localVarPostBody = null;

            // to determine the Content-Type header
            String[] localVarHttpContentTypes = new String[] {
            };
            String localVarHttpContentType = Configuration.ApiClient.SelectHeaderContentType(localVarHttpContentTypes);

            // to determine the Accept header
            String[] localVarHttpHeaderAccepts = new String[] {
            };
            String localVarHttpHeaderAccept = Configuration.ApiClient.SelectHeaderAccept(localVarHttpHeaderAccepts);
            if (localVarHttpHeaderAccept != null)
                localVarHeaderParams.Add("Accept", localVarHttpHeaderAccept);

            // set "format" to json by default
            // e.g. /pet/{petId}.{format} becomes /pet/{petId}.json
            localVarPathParams.Add("format", "json");
            if (regulation != null && regulation.GetType() != typeof(byte[]))
            {
                localVarPostBody = Configuration.ApiClient.Serialize(regulation); // http body (model) parameter
            }
            else
            {
                localVarPostBody = regulation; // byte array
            }


            // make the HTTP request
            IRestResponse localVarResponse = (IRestResponse) await Configuration.ApiClient.CallApiAsync(localVarPath,
                Method.POST, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarFileParams,
                localVarPathParams, localVarHttpContentType);

            int localVarStatusCode = (int) localVarResponse.StatusCode;

            if (ExceptionFactory != null)
            {
                Exception exception = ExceptionFactory("RegulationsPost", localVarResponse);
                if (exception != null) throw exception;
            }

            return new ApiResponse<PrivacyRegulation>(localVarStatusCode,
                localVarResponse.Headers.ToDictionary(x => x.Name, x => x.Value.ToString()),
                (PrivacyRegulation) Configuration.ApiClient.Deserialize(localVarResponse, typeof(PrivacyRegulation)));
            
        }

        /// <summary>
        /// Create a new UPP entry in the database for the user. Called when a new user is registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
        /// </summary>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="upp">The first instance of this user&#39;s UPP</param>
        /// <returns></returns>
        public void UserPrivacyPolicyPost (UserPrivacyPolicy upp)
        {
             UserPrivacyPolicyPostWithHttpInfo(upp);
        }

        /// <summary>
        /// Create a new UPP entry in the database for the user. Called when a new user is registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
        /// </summary>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="upp">The first instance of this user&#39;s UPP</param>
        /// <returns>ApiResponse of Object(void)</returns>
        public ApiResponse<Object> UserPrivacyPolicyPostWithHttpInfo (UserPrivacyPolicy upp)
        {
            // verify the required parameter 'upp' is set
            if (upp == null)
                throw new ApiException(400, "Missing required parameter 'upp' when calling POSTApi->UserPrivacyPolicyPost");

            var localVarPath = "/user_privacy_policy/";
            var localVarPathParams = new Dictionary<String, String>();
            var localVarQueryParams = new Dictionary<String, String>();
            var localVarHeaderParams = new Dictionary<String, String>(Configuration.DefaultHeader);
            var localVarFormParams = new Dictionary<String, String>();
            var localVarFileParams = new Dictionary<String, FileParameter>();
            Object localVarPostBody = null;

            // to determine the Content-Type header
            String[] localVarHttpContentTypes = new String[] {
            };
            String localVarHttpContentType = Configuration.ApiClient.SelectHeaderContentType(localVarHttpContentTypes);

            // to determine the Accept header
            String[] localVarHttpHeaderAccepts = new String[] {
            };
            String localVarHttpHeaderAccept = Configuration.ApiClient.SelectHeaderAccept(localVarHttpHeaderAccepts);
            if (localVarHttpHeaderAccept != null)
                localVarHeaderParams.Add("Accept", localVarHttpHeaderAccept);

            // set "format" to json by default
            // e.g. /pet/{petId}.{format} becomes /pet/{petId}.json
            localVarPathParams.Add("format", "json");
            if (upp != null && upp.GetType() != typeof(byte[]))
            {
                localVarPostBody = Configuration.ApiClient.Serialize(upp); // http body (model) parameter
            }
            else
            {
                localVarPostBody = upp; // byte array
            }


            // make the HTTP request
            IRestResponse localVarResponse = (IRestResponse) Configuration.ApiClient.CallApi(localVarPath,
                Method.POST, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarFileParams,
                localVarPathParams, localVarHttpContentType);

            int localVarStatusCode = (int) localVarResponse.StatusCode;

            if (ExceptionFactory != null)
            {
                Exception exception = ExceptionFactory("UserPrivacyPolicyPost", localVarResponse);
                if (exception != null) throw exception;
            }

            
            return new ApiResponse<Object>(localVarStatusCode,
                localVarResponse.Headers.ToDictionary(x => x.Name, x => x.Value.ToString()),
                null);
        }

        /// <summary>
        /// Create a new UPP entry in the database for the user. Called when a new user is registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
        /// </summary>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="upp">The first instance of this user&#39;s UPP</param>
        /// <returns>Task of void</returns>
        public async System.Threading.Tasks.Task UserPrivacyPolicyPostAsync (UserPrivacyPolicy upp)
        {
             await UserPrivacyPolicyPostAsyncWithHttpInfo(upp);

        }

        /// <summary>
        /// Create a new UPP entry in the database for the user. Called when a new user is registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
        /// </summary>
        /// <exception cref="IO.Swagger.Client.ApiException">Thrown when fails to make API call</exception>
        /// <param name="upp">The first instance of this user&#39;s UPP</param>
        /// <returns>Task of ApiResponse</returns>
        public async System.Threading.Tasks.Task<ApiResponse<Object>> UserPrivacyPolicyPostAsyncWithHttpInfo (UserPrivacyPolicy upp)
        {
            // verify the required parameter 'upp' is set
            if (upp == null)
                throw new ApiException(400, "Missing required parameter 'upp' when calling POSTApi->UserPrivacyPolicyPost");

            var localVarPath = "/user_privacy_policy/";
            var localVarPathParams = new Dictionary<String, String>();
            var localVarQueryParams = new Dictionary<String, String>();
            var localVarHeaderParams = new Dictionary<String, String>(Configuration.DefaultHeader);
            var localVarFormParams = new Dictionary<String, String>();
            var localVarFileParams = new Dictionary<String, FileParameter>();
            Object localVarPostBody = null;

            // to determine the Content-Type header
            String[] localVarHttpContentTypes = new String[] {
            };
            String localVarHttpContentType = Configuration.ApiClient.SelectHeaderContentType(localVarHttpContentTypes);

            // to determine the Accept header
            String[] localVarHttpHeaderAccepts = new String[] {
            };
            String localVarHttpHeaderAccept = Configuration.ApiClient.SelectHeaderAccept(localVarHttpHeaderAccepts);
            if (localVarHttpHeaderAccept != null)
                localVarHeaderParams.Add("Accept", localVarHttpHeaderAccept);

            // set "format" to json by default
            // e.g. /pet/{petId}.{format} becomes /pet/{petId}.json
            localVarPathParams.Add("format", "json");
            if (upp != null && upp.GetType() != typeof(byte[]))
            {
                localVarPostBody = Configuration.ApiClient.Serialize(upp); // http body (model) parameter
            }
            else
            {
                localVarPostBody = upp; // byte array
            }


            // make the HTTP request
            IRestResponse localVarResponse = (IRestResponse) await Configuration.ApiClient.CallApiAsync(localVarPath,
                Method.POST, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarFileParams,
                localVarPathParams, localVarHttpContentType);

            int localVarStatusCode = (int) localVarResponse.StatusCode;

            if (ExceptionFactory != null)
            {
                Exception exception = ExceptionFactory("UserPrivacyPolicyPost", localVarResponse);
                if (exception != null) throw exception;
            }

            
            return new ApiResponse<Object>(localVarStatusCode,
                localVarResponse.Headers.ToDictionary(x => x.Name, x => x.Value.ToString()),
                null);
        }

    }
}
