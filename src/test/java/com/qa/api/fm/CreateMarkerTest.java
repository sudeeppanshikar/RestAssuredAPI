package com.qa.api.fm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.utils.GenerateUUID;
import com.qa.api.utils.JsonPathValidator;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateMarkerTest extends BaseTest {

	String latest_map = null;

	@BeforeClass
	public void relaxhttps() {
		RestAssured.useRelaxedHTTPSValidation();

		Response response = restclient.get(BASE_URL_FM, GET_MAP, AuthType.NO_AUTH, ContentType.JSON, null, null);

		List<Map<String, String>> map_name = JsonPathValidator.readListMap(response, "$[*]['name','id']");

		latest_map = map_name.get(0).get("id");

	}

	@Test

	public void createMarkervalidation() throws IOException {

		File teamfile = new File("./src/test/resources/jsons/CreateMarker");

		String content = Files.readString(teamfile.toPath());

		content = content.replace("{{id}}", GenerateUUID.getUUID());
		content = content.replace("{{map_id}}", latest_map);	

		// Creating Marker
		Response responsePost = restclient.post(BASE_URL_FM, CREATE_MARKER_ENDPOINT, content, AuthType.API_KEY,
				ContentType.JSON);

		String expected_markerid = JsonPathValidator.read(responsePost, "$.result[0]");

		Map<String, String> map_id = new HashMap<String, String>();

		map_id.put("map", latest_map);
		
		
		/*
		 * //Get the Marker
		 * 
		 * Response response = restclient.get(BASE_URL_FM, GET_MARKER_ENDPOINT,
		 * AuthType.NO_AUTH, ContentType.JSON, null, map_id);
		 * 
		 * List<String> actual_markerList = JsonPathValidator.read(response,
		 * "$..[?(@.id=='" + expected_markerid + "')].id");
		 * 
		 * String actual_markerid = String.join(",", actual_markerList);
		 * 
		 * Assert.assertEquals(expected_markerid, actual_markerid);
		 */
	}

}
