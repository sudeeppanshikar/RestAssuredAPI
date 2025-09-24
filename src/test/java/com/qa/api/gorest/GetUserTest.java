package com.qa.api.gorest;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetUserTest extends BaseTest {

	@Test
	public void getAllUserTest() {

		Response response = restclient.get(BASE_URL_GOREST, GOREST_USERS_ENDPOINT, AuthType.BEARER_TOKEN,
				ContentType.JSON, null, null);
		Assert.assertTrue(response.statusLine().contains("OK"));

	}

	@Test
	public void getPathParameterTest() {

		Map<String, String> pathParam = new HashMap<String, String>();
		pathParam.put("userid", "7986385");	

		restclient.get(BASE_URL_GOREST, GOREST_USERS_ENDPOINT_PATHPARAMETER, AuthType.BEARER_TOKEN, ContentType.JSON,
				pathParam, null);

	}

}
