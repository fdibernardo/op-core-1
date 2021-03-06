# coding: utf-8

"""
    Policy DB

    The Policy Database that stores three types of documents in dedicated collections.   1) User Privacy Policy. Each OPERANDO user has one UPP document describing their privacy policies for each of the OSP services they are subscribed to. The UPP contains the current B2C privacy settings for a subscribed to OSP. The UPP contains the users privacy preferences. The UPP contains the G2C access policies for the OSP with justification for access.   2) The legislation policies. The regulations entered into OPERANDO using the OPERANDO regulation API.   3) The OSP descriptions and data requests. For each OSP its privacy policy, its access control rules, and the data it requests (as a workflow). For B2C, the set of privacy settings is stored. 

    OpenAPI spec version: 1.0.0
    Contact: support@operando.eu
    Generated by: https://github.com/swagger-api/swagger-codegen.git
"""


from __future__ import absolute_import

import sys
import os
import re

# python 2 and python 3 compatibility library
from six import iteritems

from ..configuration import Configuration
from ..api_client import ApiClient


class UPPApi(object):
    """
    NOTE: This class is auto generated by the swagger code generator program.
    Do not edit the class manually.
    Ref: https://github.com/swagger-api/swagger-codegen
    """

    def __init__(self, api_client=None):
        config = Configuration()
        if api_client:
            self.api_client = api_client
        else:
            if not config.api_client:
                config.api_client = ApiClient()
            self.api_client = config.api_client

    def user_privacy_policy_get(self, filter, **kwargs):
        """
        Perform a search query across the collection of UPPs.
        The query contains a json object (names, values) and the request returns the list of documents (UPPs) where the filter matches i.e. each document contains fields with those values. 
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please define a `callback` function
        to be invoked when receiving the response.
        >>> def callback_function(response):
        >>>     pprint(response)
        >>>
        >>> thread = api.user_privacy_policy_get(filter, callback=callback_function)

        :param callback function: The callback function
            for asynchronous request. (optional)
        :param str filter: The query filter to be matched - ?filter={json description} (required)
        :return: list[UserPrivacyPolicy]
                 If the method is called asynchronously,
                 returns the request thread.
        """
        kwargs['_return_http_data_only'] = True
        if kwargs.get('callback'):
            return self.user_privacy_policy_get_with_http_info(filter, **kwargs)
        else:
            (data) = self.user_privacy_policy_get_with_http_info(filter, **kwargs)
            return data

    def user_privacy_policy_get_with_http_info(self, filter, **kwargs):
        """
        Perform a search query across the collection of UPPs.
        The query contains a json object (names, values) and the request returns the list of documents (UPPs) where the filter matches i.e. each document contains fields with those values. 
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please define a `callback` function
        to be invoked when receiving the response.
        >>> def callback_function(response):
        >>>     pprint(response)
        >>>
        >>> thread = api.user_privacy_policy_get_with_http_info(filter, callback=callback_function)

        :param callback function: The callback function
            for asynchronous request. (optional)
        :param str filter: The query filter to be matched - ?filter={json description} (required)
        :return: list[UserPrivacyPolicy]
                 If the method is called asynchronously,
                 returns the request thread.
        """

        all_params = ['filter']
        all_params.append('callback')
        all_params.append('_return_http_data_only')
        all_params.append('_preload_content')
        all_params.append('_request_timeout')

        params = locals()
        for key, val in iteritems(params['kwargs']):
            if key not in all_params:
                raise TypeError(
                    "Got an unexpected keyword argument '%s'"
                    " to method user_privacy_policy_get" % key
                )
            params[key] = val
        del params['kwargs']
        # verify the required parameter 'filter' is set
        if ('filter' not in params) or (params['filter'] is None):
            raise ValueError("Missing the required parameter `filter` when calling `user_privacy_policy_get`")


        collection_formats = {}

        resource_path = '/user_privacy_policy/'.replace('{format}', 'json')
        path_params = {}

        query_params = {}
        if 'filter' in params:
            query_params['filter'] = params['filter']

        header_params = {}

        form_params = []
        local_var_files = {}

        body_params = None
        # Authentication setting
        auth_settings = []

        return self.api_client.call_api(resource_path, 'GET',
                                        path_params,
                                        query_params,
                                        header_params,
                                        body=body_params,
                                        post_params=form_params,
                                        files=local_var_files,
                                        response_type='list[UserPrivacyPolicy]',
                                        auth_settings=auth_settings,
                                        callback=params.get('callback'),
                                        _return_http_data_only=params.get('_return_http_data_only'),
                                        _preload_content=params.get('_preload_content', True),
                                        _request_timeout=params.get('_request_timeout'),
                                        collection_formats=collection_formats)

    def user_privacy_policy_post(self, upp, **kwargs):
        """
        Create a new UPP entry in the database for the user.
        Called when a new user is registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please define a `callback` function
        to be invoked when receiving the response.
        >>> def callback_function(response):
        >>>     pprint(response)
        >>>
        >>> thread = api.user_privacy_policy_post(upp, callback=callback_function)

        :param callback function: The callback function
            for asynchronous request. (optional)
        :param UserPrivacyPolicy upp: The first instance of this user's UPP (required)
        :return: str
                 If the method is called asynchronously,
                 returns the request thread.
        """
        kwargs['_return_http_data_only'] = True
        if kwargs.get('callback'):
            return self.user_privacy_policy_post_with_http_info(upp, **kwargs)
        else:
            (data) = self.user_privacy_policy_post_with_http_info(upp, **kwargs)
            return data

    def user_privacy_policy_post_with_http_info(self, upp, **kwargs):
        """
        Create a new UPP entry in the database for the user.
        Called when a new user is registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please define a `callback` function
        to be invoked when receiving the response.
        >>> def callback_function(response):
        >>>     pprint(response)
        >>>
        >>> thread = api.user_privacy_policy_post_with_http_info(upp, callback=callback_function)

        :param callback function: The callback function
            for asynchronous request. (optional)
        :param UserPrivacyPolicy upp: The first instance of this user's UPP (required)
        :return: str
                 If the method is called asynchronously,
                 returns the request thread.
        """

        all_params = ['upp']
        all_params.append('callback')
        all_params.append('_return_http_data_only')
        all_params.append('_preload_content')
        all_params.append('_request_timeout')

        params = locals()
        for key, val in iteritems(params['kwargs']):
            if key not in all_params:
                raise TypeError(
                    "Got an unexpected keyword argument '%s'"
                    " to method user_privacy_policy_post" % key
                )
            params[key] = val
        del params['kwargs']
        # verify the required parameter 'upp' is set
        if ('upp' not in params) or (params['upp'] is None):
            raise ValueError("Missing the required parameter `upp` when calling `user_privacy_policy_post`")


        collection_formats = {}

        resource_path = '/user_privacy_policy/'.replace('{format}', 'json')
        path_params = {}

        query_params = {}

        header_params = {}

        form_params = []
        local_var_files = {}

        body_params = None
        if 'upp' in params:
            body_params = params['upp']
        # Authentication setting
        auth_settings = []

        return self.api_client.call_api(resource_path, 'POST',
                                        path_params,
                                        query_params,
                                        header_params,
                                        body=body_params,
                                        post_params=form_params,
                                        files=local_var_files,
                                        response_type='str',
                                        auth_settings=auth_settings,
                                        callback=params.get('callback'),
                                        _return_http_data_only=params.get('_return_http_data_only'),
                                        _preload_content=params.get('_preload_content', True),
                                        _request_timeout=params.get('_request_timeout'),
                                        collection_formats=collection_formats)

    def user_privacy_policy_user_id_delete(self, user_id, **kwargs):
        """
        Remove the UPP entry in the database for the user.
        Called when a user leaves operando. Their privacy preferences and policies are deleted from the database. 
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please define a `callback` function
        to be invoked when receiving the response.
        >>> def callback_function(response):
        >>>     pprint(response)
        >>>
        >>> thread = api.user_privacy_policy_user_id_delete(user_id, callback=callback_function)

        :param callback function: The callback function
            for asynchronous request. (optional)
        :param str user_id: The user identifier number (required)
        :return: None
                 If the method is called asynchronously,
                 returns the request thread.
        """
        kwargs['_return_http_data_only'] = True
        if kwargs.get('callback'):
            return self.user_privacy_policy_user_id_delete_with_http_info(user_id, **kwargs)
        else:
            (data) = self.user_privacy_policy_user_id_delete_with_http_info(user_id, **kwargs)
            return data

    def user_privacy_policy_user_id_delete_with_http_info(self, user_id, **kwargs):
        """
        Remove the UPP entry in the database for the user.
        Called when a user leaves operando. Their privacy preferences and policies are deleted from the database. 
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please define a `callback` function
        to be invoked when receiving the response.
        >>> def callback_function(response):
        >>>     pprint(response)
        >>>
        >>> thread = api.user_privacy_policy_user_id_delete_with_http_info(user_id, callback=callback_function)

        :param callback function: The callback function
            for asynchronous request. (optional)
        :param str user_id: The user identifier number (required)
        :return: None
                 If the method is called asynchronously,
                 returns the request thread.
        """

        all_params = ['user_id']
        all_params.append('callback')
        all_params.append('_return_http_data_only')
        all_params.append('_preload_content')
        all_params.append('_request_timeout')

        params = locals()
        for key, val in iteritems(params['kwargs']):
            if key not in all_params:
                raise TypeError(
                    "Got an unexpected keyword argument '%s'"
                    " to method user_privacy_policy_user_id_delete" % key
                )
            params[key] = val
        del params['kwargs']
        # verify the required parameter 'user_id' is set
        if ('user_id' not in params) or (params['user_id'] is None):
            raise ValueError("Missing the required parameter `user_id` when calling `user_privacy_policy_user_id_delete`")


        collection_formats = {}

        resource_path = '/user_privacy_policy/{user-id}/'.replace('{format}', 'json')
        path_params = {}
        if 'user_id' in params:
            path_params['user-id'] = params['user_id']

        query_params = {}

        header_params = {}

        form_params = []
        local_var_files = {}

        body_params = None
        # Authentication setting
        auth_settings = []

        return self.api_client.call_api(resource_path, 'DELETE',
                                        path_params,
                                        query_params,
                                        header_params,
                                        body=body_params,
                                        post_params=form_params,
                                        files=local_var_files,
                                        response_type=None,
                                        auth_settings=auth_settings,
                                        callback=params.get('callback'),
                                        _return_http_data_only=params.get('_return_http_data_only'),
                                        _preload_content=params.get('_preload_content', True),
                                        _request_timeout=params.get('_request_timeout'),
                                        collection_formats=collection_formats)

    def user_privacy_policy_user_id_get(self, user_id, **kwargs):
        """
        Read the user privacy policy for the given user id.
        Get a specific UPP document via the user's id. This will return the full user privacy policy document in json format. 
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please define a `callback` function
        to be invoked when receiving the response.
        >>> def callback_function(response):
        >>>     pprint(response)
        >>>
        >>> thread = api.user_privacy_policy_user_id_get(user_id, callback=callback_function)

        :param callback function: The callback function
            for asynchronous request. (optional)
        :param str user_id: The user identifier number (required)
        :return: UserPrivacyPolicy
                 If the method is called asynchronously,
                 returns the request thread.
        """
        kwargs['_return_http_data_only'] = True
        if kwargs.get('callback'):
            return self.user_privacy_policy_user_id_get_with_http_info(user_id, **kwargs)
        else:
            (data) = self.user_privacy_policy_user_id_get_with_http_info(user_id, **kwargs)
            return data

    def user_privacy_policy_user_id_get_with_http_info(self, user_id, **kwargs):
        """
        Read the user privacy policy for the given user id.
        Get a specific UPP document via the user's id. This will return the full user privacy policy document in json format. 
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please define a `callback` function
        to be invoked when receiving the response.
        >>> def callback_function(response):
        >>>     pprint(response)
        >>>
        >>> thread = api.user_privacy_policy_user_id_get_with_http_info(user_id, callback=callback_function)

        :param callback function: The callback function
            for asynchronous request. (optional)
        :param str user_id: The user identifier number (required)
        :return: UserPrivacyPolicy
                 If the method is called asynchronously,
                 returns the request thread.
        """

        all_params = ['user_id']
        all_params.append('callback')
        all_params.append('_return_http_data_only')
        all_params.append('_preload_content')
        all_params.append('_request_timeout')

        params = locals()
        for key, val in iteritems(params['kwargs']):
            if key not in all_params:
                raise TypeError(
                    "Got an unexpected keyword argument '%s'"
                    " to method user_privacy_policy_user_id_get" % key
                )
            params[key] = val
        del params['kwargs']
        # verify the required parameter 'user_id' is set
        if ('user_id' not in params) or (params['user_id'] is None):
            raise ValueError("Missing the required parameter `user_id` when calling `user_privacy_policy_user_id_get`")


        collection_formats = {}

        resource_path = '/user_privacy_policy/{user-id}/'.replace('{format}', 'json')
        path_params = {}
        if 'user_id' in params:
            path_params['user-id'] = params['user_id']

        query_params = {}

        header_params = {}

        form_params = []
        local_var_files = {}

        body_params = None
        # Authentication setting
        auth_settings = []

        return self.api_client.call_api(resource_path, 'GET',
                                        path_params,
                                        query_params,
                                        header_params,
                                        body=body_params,
                                        post_params=form_params,
                                        files=local_var_files,
                                        response_type='UserPrivacyPolicy',
                                        auth_settings=auth_settings,
                                        callback=params.get('callback'),
                                        _return_http_data_only=params.get('_return_http_data_only'),
                                        _preload_content=params.get('_preload_content', True),
                                        _request_timeout=params.get('_request_timeout'),
                                        collection_formats=collection_formats)

    def user_privacy_policy_user_id_put(self, user_id, upp, **kwargs):
        """
        Update UPP entry in the database for the user.
        Called when a user makes a change to the UPP registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please define a `callback` function
        to be invoked when receiving the response.
        >>> def callback_function(response):
        >>>     pprint(response)
        >>>
        >>> thread = api.user_privacy_policy_user_id_put(user_id, upp, callback=callback_function)

        :param callback function: The callback function
            for asynchronous request. (optional)
        :param str user_id: The user identifier number (required)
        :param UserPrivacyPolicy upp: The changed instance of this user's UPP (required)
        :return: None
                 If the method is called asynchronously,
                 returns the request thread.
        """
        kwargs['_return_http_data_only'] = True
        if kwargs.get('callback'):
            return self.user_privacy_policy_user_id_put_with_http_info(user_id, upp, **kwargs)
        else:
            (data) = self.user_privacy_policy_user_id_put_with_http_info(user_id, upp, **kwargs)
            return data

    def user_privacy_policy_user_id_put_with_http_info(self, user_id, upp, **kwargs):
        """
        Update UPP entry in the database for the user.
        Called when a user makes a change to the UPP registered with operando. Their new privacy preferences are passed in the UPP document and stored in the policy DB. 
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please define a `callback` function
        to be invoked when receiving the response.
        >>> def callback_function(response):
        >>>     pprint(response)
        >>>
        >>> thread = api.user_privacy_policy_user_id_put_with_http_info(user_id, upp, callback=callback_function)

        :param callback function: The callback function
            for asynchronous request. (optional)
        :param str user_id: The user identifier number (required)
        :param UserPrivacyPolicy upp: The changed instance of this user's UPP (required)
        :return: None
                 If the method is called asynchronously,
                 returns the request thread.
        """

        all_params = ['user_id', 'upp']
        all_params.append('callback')
        all_params.append('_return_http_data_only')
        all_params.append('_preload_content')
        all_params.append('_request_timeout')

        params = locals()
        for key, val in iteritems(params['kwargs']):
            if key not in all_params:
                raise TypeError(
                    "Got an unexpected keyword argument '%s'"
                    " to method user_privacy_policy_user_id_put" % key
                )
            params[key] = val
        del params['kwargs']
        # verify the required parameter 'user_id' is set
        if ('user_id' not in params) or (params['user_id'] is None):
            raise ValueError("Missing the required parameter `user_id` when calling `user_privacy_policy_user_id_put`")
        # verify the required parameter 'upp' is set
        if ('upp' not in params) or (params['upp'] is None):
            raise ValueError("Missing the required parameter `upp` when calling `user_privacy_policy_user_id_put`")


        collection_formats = {}

        resource_path = '/user_privacy_policy/{user-id}/'.replace('{format}', 'json')
        path_params = {}
        if 'user_id' in params:
            path_params['user-id'] = params['user_id']

        query_params = {}

        header_params = {}

        form_params = []
        local_var_files = {}

        body_params = None
        if 'upp' in params:
            body_params = params['upp']
        # Authentication setting
        auth_settings = []

        return self.api_client.call_api(resource_path, 'PUT',
                                        path_params,
                                        query_params,
                                        header_params,
                                        body=body_params,
                                        post_params=form_params,
                                        files=local_var_files,
                                        response_type=None,
                                        auth_settings=auth_settings,
                                        callback=params.get('callback'),
                                        _return_http_data_only=params.get('_return_http_data_only'),
                                        _preload_content=params.get('_preload_content', True),
                                        _request_timeout=params.get('_request_timeout'),
                                        collection_formats=collection_formats)
