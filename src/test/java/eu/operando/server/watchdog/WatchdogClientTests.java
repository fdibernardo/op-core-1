/*
 * Copyright (c) 2016 Oxford Computer Consultants Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the The MIT License (MIT).
 * which accompanies this distribution, and is available at
 * http://opensource.org/licenses/MIT
 *
 * Contributors:
 *    Matthew Gallagher (Oxford Computer Consultants) - Creation.
 * Initially developed in the context of OPERANDO EU project www.operando.eu
 */
package eu.operando.server.watchdog;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.assertThat;

import java.util.Vector;

import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import eu.operando.OperandoClientTests;
/**
 * TODO - handle HTTP errors being returned
 */
public class WatchdogClientTests implements OperandoClientTests
{
	private WatchdogClient client = new WatchdogClient(URL_USER_DEVICE_ENFORCEMENT, URL_OSP_ENFORCEMENT,
			URL_EMAIL_SERVICES);
	
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(PORT_WIREMOCK);
	
	/**
	 * UDE
	 */
	@Test
	public void testGetPrivacySettingsCurrent_CorrectHttpRequest()
	{
		//Set Up
		wireMockRule.stubFor(get(urlPathEqualTo(ENDPOINT_USER_DEVICE_ENFORCEMENT_PRIVACY_SETTINGS))
				.willReturn(aResponse()));
		
		int userId = 1;
		int ospId = 2;
		
		//Exercise
		client.getPrivacySettingsCurrent(userId, ospId);
		
		//Verify
		wireMockRule.verify(getRequestedFor(urlPathEqualTo(ENDPOINT_USER_DEVICE_ENFORCEMENT_PRIVACY_SETTINGS))
				.withQueryParam("user_id", equalTo("" + userId))
				.withQueryParam("osp_id", equalTo("" + ospId)));
	}
	@Test
	public void testGetCurrentPrivacySettings_HandlesSuccessfulResponseCorrectly()
	{
		Vector<PrivacySetting> settingsExpected = createTestVectorPrivacySettings();
		stubForSuccessWithPrivacySettingsAsJson(settingsExpected, ENDPOINT_USER_DEVICE_ENFORCEMENT_PRIVACY_SETTINGS);
		//Exercise
		Vector<PrivacySetting> settingsActual = client.getPrivacySettingsCurrent(3, 4);
		
		//Verify
		assertThat(settingsActual, is(equalTo(settingsExpected)));
	}
	
	/**
	 * OSE
	 */
	@Test
	public void testGetPrivacySettingsRequired_CorrectHttpRequest()
	{
		//Set Up
		int userId = 1;
		int ospId = 2;

		String endpoint = String.format(ENDPOINT_OSP_ENFORCEMENT_PRIVACY_SETTINGS, ospId);
		
		wireMockRule.stubFor(get(urlPathEqualTo(endpoint))
				.willReturn(aResponse()));
	
		//Exercise
		client.getPrivacySettingsRequired(userId, ospId);
		
		//Verify
		wireMockRule.verify(getRequestedFor(urlPathEqualTo(endpoint))
				.withQueryParam("user_id", equalTo("" + userId)));
	}
	@Test
	public void testGetRequiredPrivacySettings_HandlesSuccessfulResponseCorrectly()
	{
		//Set Up
		Vector<PrivacySetting> settingsExpected = createTestVectorPrivacySettings();
		int ospId = 4;
		stubForSuccessWithPrivacySettingsAsJson(settingsExpected, String.format(ENDPOINT_OSP_ENFORCEMENT_PRIVACY_SETTINGS, ospId));
		
		//Exercise
		int userId = 3;
		Vector<PrivacySetting> settingsActual = client.getPrivacySettingsRequired(userId, ospId);
		
		//Verify
		assertThat(settingsActual, is(equalTo(settingsExpected)));
	}
	
	/**
	 * Privacy Settings helper methods.
	 */
	private Vector<PrivacySetting> createTestVectorPrivacySettings()
	{
		//Create a vector of multiple privacy settings.
		Vector<PrivacySetting> vSettingsExpected = new Vector<PrivacySetting>();
		PrivacySetting settingOne = new PrivacySetting(1, "descOne", "nameOne", "keyOne", "valueOne");
		PrivacySetting settingTwo = new PrivacySetting(2, "descTwo", "nameTwo", "keyTwo", "valueTwo");
		vSettingsExpected.add(settingOne);
		vSettingsExpected.add(settingTwo);
		return vSettingsExpected;
	}
	private void stubForSuccessWithPrivacySettingsAsJson(Vector<PrivacySetting> vSettingsExpected, String endPoint)
	{
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		String jsonArraySettings = gson.toJson(vSettingsExpected);
		
		wireMockRule.stubFor(get(urlPathEqualTo(endPoint))
				.willReturn(aResponse()
						.withStatus(HTTP_STATUS_CODE_SUCCESS)
						.withBody(jsonArraySettings)));
	}
	
	@Test
	public void testSendEmailToPrivacyAnalyst_CorrectHttpRequest()
	{
		//Set Up
		wireMockRule.stubFor(get(urlPathEqualTo(ENDPOINT_EMAIL_SERVICES_EMAIL))
				.willReturn(aResponse()));

		int userId = 1;
		int ospId = 2;
		int userIdPrivacyAnalyst = 3;
		
		//TODO - this should be read from a config file, and the test should check that the value in the file is used.
		client.setUserIdPrivacyAnalyst(userIdPrivacyAnalyst);
				
		//Exercise
		client.emailPrivacyAnalystAboutUserPrivacySettingDiscrepancy(userId, ospId);

		//Verify
		Vector<Integer> to = new Vector<Integer>();
		to.add(userIdPrivacyAnalyst);
		String content = "The privacy settings for user " + userId + " with OSP " + ospId + " are not as required. This requires action.";
		int senderIdWatchdog = 4; //TODO - what should this be?
		
		Email emailExpected = new Email(senderIdWatchdog, to, new Vector<Integer>(), new Vector<Integer>(), content, new Vector<Attachment>());
		Gson gson = new GsonBuilder().create();
		String jsonEmail = gson.toJson(emailExpected);
		
		wireMockRule.verify(postRequestedFor(urlPathEqualTo(ENDPOINT_EMAIL_SERVICES_EMAIL))
				.withRequestBody(equalToJson(jsonEmail)));
	}
}
