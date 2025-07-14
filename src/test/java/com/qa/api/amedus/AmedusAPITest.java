package com.qa.api.amedus;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.manager.ConfigManager;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AmedusAPITest extends BaseTest {

	@BeforeMethod

	public void getOauthToken() {

		Response response = restclient.post(BASE_URL_AMEDUS, AMEDUS_ENDPOINT, AuthType.NO_AUTH, ContentType.URLENC,
				ConfigManager.get("granttype"), ConfigManager.get("clientid"), ConfigManager.get("clientsecret"));

		String oauth_token = response.jsonPath().getString("access_token");
		ConfigManager.set("bearertoken", oauth_token);

	}

	@Test
	public void getAmedusflight() {

		// https://test.api.amadeus.com/v1/shopping/flight-destinations?origin=PAR&maxPrice=200
		// Maps.of("origin", "PAR", "maxPrice", "200");
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("origin", "PAR");
		queryParams.put("maxPrice", "200");

		Response response = restclient.get(BASE_URL_AMEDUS, AMADEUS_FLIGHT_DEST_ENDPOINT, AuthType.BEARER_TOKEN,
				ContentType.ANY, null, queryParams);
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
