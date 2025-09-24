package com.qa.api.mock;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.utils.StringUtils;
import com.qa.api.wiremock.APIMocks;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MockCreateUserAPI extends BaseTest {
	String tran_id;
	@Test(enabled = true)
	public void mockcreateTest() {
		//APIMocks.defineGetUserMock();
		APIMocks.defineGetUserMockWithJsonFile();
		Response response = restclient.get(MOCK_URL, MOCK_ENDPOINT, AuthType.NO_AUTH, ContentType.JSON, null, null);

		response.prettyPrint();

	}

	@Test
	public void getBanktransactionID() {
		APIMocks.defineBankTransactionID();

		File userfile = new File("./src/test/resources/jsons/user.json");

		Response response = restclient.post(MOCK_URL, MOCK_ENDPOINT, userfile, AuthType.NO_AUTH, ContentType.JSON);

		 tran_id = Integer.toString(response.jsonPath().getInt("id"));
		System.out.println("Your transaction id is " + tran_id);

	}

	@Test(priority = Integer.MAX_VALUE-1)
	public void getPathParameterTest() {

		Map<String, String> pathParam = new HashMap<String, String>();
		pathParam.put("userid", tran_id);

		restclient.get(BASE_URL_GOREST, GOREST_USERS_ENDPOINT_PATHPARAMETER, AuthType.BEARER_TOKEN, ContentType.JSON,
				pathParam, null);

	}
	
}
