package com.qa.api.gorest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.pojo.CreateGoRestUser;
import com.qa.api.utils.StringUtils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteUserTest extends BaseTest {

	@Test
	public void deleteUserTest() {

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

		// Delete the User - Delete call

		Response responseDel = restclient.delete(BASE_URL_GOREST, GOREST_USERS_ENDPOINT + "/" + userid,
				AuthType.BEARER_TOKEN, ContentType.JSON);

		Assert.assertTrue(responseDel.statusLine().contains("No Content"));

		// Get the user - Get Call - To confirm the deletion

		responseGet = restclient.get(BASE_URL_GOREST, GOREST_USERS_ENDPOINT +"/"+userid, AuthType.BEARER_TOKEN,
				ContentType.JSON, null, null);
		Assert.assertTrue(responseGet.statusLine().contains("Not Found"));
		Assert.assertEquals(responseGet.jsonPath().getString("message"),"Resource not found");

	}

}
