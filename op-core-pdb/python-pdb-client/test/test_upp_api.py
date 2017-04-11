# coding: utf-8

"""
    Policy DB

    The Policy Database that stores three types of documents in dedicated collections.   1) User Privacy Policy. Each OPERANDO user has one UPP document describing their privacy policies for each of the OSP services they are subscribed to. The UPP contains the current B2C privacy settings for a subscribed to OSP. The UPP contains the users privacy preferences. The UPP contains the G2C access policies for the OSP with justification for access.   2) The legislation policies. The regulations entered into OPERANDO using the OPERANDO regulation API.   3) The OSP descriptions and data requests. For each OSP its privacy policy, its access control rules, and the data it requests (as a workflow). For B2C, the set of privacy settings is stored. 

    OpenAPI spec version: 1.0.0
    Contact: support@operando.eu
    Generated by: https://github.com/swagger-api/swagger-codegen.git
"""


from __future__ import absolute_import

import os
import sys
import unittest

import pdb_client
from pdb_client.rest import ApiException
from pdb_client.apis.upp_api import UPPApi

import aapi_client
from aapi_client.rest import ApiException as AApiException
from aapi_client.models import UserCredential

class TestUPPApi(unittest.TestCase):
    """ UPPApi unit test stubs """
    BASE_PATH = "http://10.136.24.87:8080"
    BASE_PATH = "http://integration.operando.esilab.org:8096/operando/core"

    AAPI_PATH = "http://integration.operando.esilab.org:8135/operando/interfaces/aapi"
    _osp_id = "pdb/user_privacy_policy/.*"
    _osp_policy = None

    def setUp(self):
        # try to get sertice ticket
        aapi_cli = aapi_client.ApiClient(host=self.AAPI_PATH)
        aapi = aapi_client.apis.DefaultApi(aapi_cli)
        user_credential =  UserCredential("panos2", "operando")
        self.tgt = ""
        try:
            self.tgt = aapi.aapi_tickets_post(user_credential)
            print("setUp got ticket: ", self.tgt)
        except AApiException as e:
            print("Exception when trying to get a ticket %s\n" % e)

        self.st = ""
        if self.tgt:
            try:
                self.st = aapi.aapi_tickets_tgt_post(self.tgt, self._osp_id)
                print("setUp got service ticket:", self.st)
            except AApiException as e:
                print("Exception when tryint to get OSP service ticket %s\n", e)

        self.api = pdb_client.apis.upp_api.UPPApi()
        base_path = "".join([self.BASE_PATH, "/pdb"])
        api_client = pdb_client.ApiClient(host=base_path)
        if self.st:
            api_client.set_default_header("Service-Ticket", self.st)
        self.api = pdb_client.apis.upp_api.UPPApi(api_client)

    def tearDown(self):
        pass

    # @unittest.skip("demo skipping")
    def test_upp_all(self):
        print("Test UPP all")
        print("Test case for user_privacy_policy_get with filter")
        upp_all_filter = "{\"user_id\":\"\"}"
        # upp_all_filter = "%7B%27user_id:%27%27%7D"
        api_response = self.api.user_privacy_policy_get(upp_all_filter)
        upp_list_length = len(api_response)
        self.assertNotEqual(api_response, None)
        try:
           assert len(api_response) > 0
        except Exception as e:
           print("Test UPP failed to get any stored upp")
           raise e
        upp = api_response[0]

        print("Test case for user_privacy_policy_post", upp_list_length)
        upp.user_id = "unittest_user"
        print("UPP for post:", upp)
        api_response = self.api.user_privacy_policy_post(upp)
        print("POST response:", api_response)
        self.assertNotEqual(api_response, None)
        upp_id = api_response

        print("Test case for user_privacy_policy_id_get")
        api_response = self.api.user_privacy_policy_user_id_get(upp_id)
        self.assertEqual(api_response.user_id, upp_id)

        print("Test case for user_privacy_policy_id_put")
        user_id = "unittest_user1"
        upp.user_id = user_id
        api_response = self.api.user_privacy_policy_user_id_put(upp_id, upp)
        print("PUT response", api_response)
        api_response = self.api.user_privacy_policy_user_id_get(user_id)
        self.assertEqual(api_response.user_id, user_id)

        print("Test case for user_privacy_policy_id_delete")
        api_response = self.api.user_privacy_policy_user_id_delete(user_id)
        print("DELETE:", api_response)

        api_response = self.api.user_privacy_policy_get(upp_all_filter)
        self.assertEqual(upp_list_length, len(api_response))


    @unittest.skip("demo skipping")
    def test_user_privacy_policy_get(self):
        """
        Test case for user_privacy_policy_get

        Perform a search query across the collection of UPPs.
        """
        pass

    @unittest.skip("demo skipping")
    def test_user_privacy_policy_post(self):
        """
        Test case for user_privacy_policy_post

        Create a new UPP entry in the database for the user.
        """
        pass

    @unittest.skip("demo skipping")
    def test_user_privacy_policy_user_id_delete(self):
        """
        Test case for user_privacy_policy_user_id_delete

        Remove the UPP entry in the database for the user.
        """
        pass

    @unittest.skip("demo skipping")
    def test_user_privacy_policy_user_id_get(self):
        """
        Test case for user_privacy_policy_user_id_get

        Read the user privacy policy for the given user id.
        """
        pass

    @unittest.skip("demo skipping")
    def test_user_privacy_policy_user_id_put(self):
        """
        Test case for user_privacy_policy_user_id_put

        Update UPP entry in the database for the user.
        """
        pass


if __name__ == '__main__':
    unittest.main()
