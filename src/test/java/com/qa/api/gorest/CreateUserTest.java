package com.qa.api.gorest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.pojo.CreateGoRestUser;
import com.qa.api.utils.StringUtils;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateUserTest extends BaseTest {

	@Test
	public void creatUserThroughJsonStringTest() {

		String Body = "{\n" + "    \"name\": \"seemaqwq\",\n" + "    \"gender\": \"female\",\n" + "    \"email\": \""
				+ StringUtils.getRandomemailid() + "\",\n" + "    \"status\": \"active\"\n" + "}";

		Response response = restclient.post(BASE_URL_GOREST, GOREST_USERS_ENDPOINT, Body, AuthType.BEARER_TOKEN,
				ContentType.JSON);

		Assert.assertTrue(response.statusLine().contains("Created"));

		JsonPath jsonpath = response.jsonPath();
		Integer userid = jsonpath.getInt("id");

		System.out.println(userid);

	}

	@Test
	public void creatUserThroughPojoTest() {

		CreateGoRestUser user = new CreateGoRestUser("priya", StringUtils.getRandomemailid(), "female", "active");

		Response response = restclient.post(BASE_URL_GOREST, GOREST_USERS_ENDPOINT, user, AuthType.BEARER_TOKEN,
				ContentType.JSON);

		Assert.assertTrue(response.statusLine().contains("Created"));

		JsonPath jsonpath = response.jsonPath();
		Integer userid = jsonpath.getInt("id");

		System.out.println(userid);

	}

	@Test
	public void CreateUserWithJsonFileWithStringReplacementTest() {

		String rawjson = null;

		try {
			rawjson = new String(Files.readAllBytes(Paths.get("./src/test/resources/jsons/user2.json")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rawjson = rawjson.replace("{{emailid}}", StringUtils.getRandomemailid());

		Response response = restclient.post(BASE_URL_GOREST, GOREST_USERS_ENDPOINT, rawjson, AuthType.BEARER_TOKEN,
				ContentType.JSON);

		Assert.assertTrue(response.statusLine().contains("Created"));

		JsonPath jsonpath = response.jsonPath();
		Integer userid = jsonpath.getInt("id");

		System.out.println(userid);

	}

	@Test (enabled = false)
	public void CreateUserWithJsonFileTest() {

				
		String rawjson = null;

		try {
			rawjson = new String(Files.readAllBytes(Paths.get("./src/test/resources/jsons/user.json")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rawjson = rawjson.replace("{{emailid}}", StringUtils.getRandomemailid());
		
		
		File filetype = new File ("./src/test/resources/jsons/user.json");
		
		Response response = restclient.post(BASE_URL_GOREST, GOREST_USERS_ENDPOINT, filetype, AuthType.BEARER_TOKEN,
				ContentType.JSON);

		Assert.assertTrue(response.statusLine().contains("Created"));

		JsonPath jsonpath = response.jsonPath();
		Integer userid = jsonpath.getInt("id");

		System.out.println(userid);
	}

}
