package com.qa.api.gorest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.pojo.CreateGoRestUser;
import com.qa.api.utils.StringUtils;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateUserTest extends BaseTest {

	@Test
	public void updateUserTest() {

		// Create the User - Post call

		CreateGoRestUser user = CreateGoRestUser.builder().name("Shefali").email(StringUtils.getRandomemailid())
				.gender("female").status("active").build();

		Response responsePost = restclient.post(BASE_URL_GOREST, GOREST_USERS_ENDPOINT, user, AuthType.BEARER_TOKEN,
				ContentType.JSON);

		Assert.assertEquals(responsePost.jsonPath().getString("name"), user.getName());
		Assert.assertNotNull(responsePost.jsonPath().getInt("id"));

		Integer userid = responsePost.jsonPath().getInt("id");

		System.out.println("User id created and =>" + userid);

		// Get the user - Get Call

		Response responseGet = restclient.get(BASE_URL_GOREST, GOREST_USERS_ENDPOINT + "/" + userid,
				AuthType.BEARER_TOKEN, ContentType.JSON, null, null);
		Assert.assertTrue(responseGet.statusLine().contains("OK"));
		Assert.assertEquals(responseGet.jsonPath().getInt("id"), userid);

		// Update the User - Put Call

		user.setName("Chaya");
		user.setStatus("inactive");

		Response responsePut = restclient.put(BASE_URL_GOREST, GOREST_USERS_ENDPOINT + "/" + userid, user,
				AuthType.BEARER_TOKEN, ContentType.JSON);
		Assert.assertTrue(responsePut.statusLine().contains("OK"));
		Assert.assertEquals(responsePut.jsonPath().getInt("id"), userid);
		Assert.assertEquals(responsePut.jsonPath().getString("name"), user.getName());
		Assert.assertEquals(responsePut.jsonPath().getString("status"), user.getStatus());

		// Get the User - get call
		responseGet = restclient.get(BASE_URL_GOREST, GOREST_USERS_ENDPOINT + "/" + userid, AuthType.BEARER_TOKEN,
				ContentType.JSON, null, null);
		Assert.assertTrue(responseGet.statusLine().contains("OK"));
		Assert.assertEquals(responseGet.jsonPath().getInt("id"), userid);
		Assert.assertEquals(responseGet.jsonPath().getString("name"), user.getName());
		Assert.assertEquals(responseGet.jsonPath().getString("status"), user.getStatus());

	}

}
