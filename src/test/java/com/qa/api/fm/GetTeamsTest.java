package com.qa.api.fm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.utils.JsonPathValidator;
import com.qa.api.utils.StringUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetTeamsTest extends BaseTest {

	/*
	 * @BeforeClass public void relaxhttps() {
	 * RestAssured.useRelaxedHTTPSValidation(); }
	 */

	@Test
	public void createTeamTest() throws IOException {

		File teamfile = new File("./src/test/resources/jsons/CreateTeam");

		String content = Files.readString(teamfile.toPath());

		content = content.replace("{{name}}", StringUtils.randomString());
		content = content.replace("{id}", StringUtils.randomvalue());

		Response responsePost = restclient.post(BASE_URL_FM, CREATE_TEAM, content, AuthType.API_KEY, ContentType.JSON);

		List<String> error = JsonPath.parse(responsePost.asString()).read("$..result_text_intl_data");
		
		/*
		 * String error_str = String.join(",", error);
		 * 
		 * 
		 * System.out.println(error_str);
		 */
		
		
		//{\"fields_and_error_codes\": \"{'name': ['blank']}\"}

		
		  String expected_team_id = responsePost.jsonPath().getString("result.id");
		  
		  Response responseGet = restclient.get(BASE_URL_FM, GET_TEAM,
		  AuthType.NO_AUTH, ContentType.JSON, null, null);
		  
		  List<String> actual_team_list = JsonPathValidator.read(responseGet,
		  "$..[?(@.id== '" + expected_team_id + "')].id");
		  
		  String actual_team_id = String.join(",", actual_team_list);
		  
		  Assert.assertEquals(actual_team_id, expected_team_id);
		 

	}

}
