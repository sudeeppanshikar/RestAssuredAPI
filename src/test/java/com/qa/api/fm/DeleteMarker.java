package com.qa.api.fm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

public class DeleteMarker extends BaseTest {

	String latest_map = null;

	@BeforeClass
	public void relaxhttps() {
		RestAssured.useRelaxedHTTPSValidation();

		// Fetching the Mapid
		Response response = restclient.get(BASE_URL_FM, GET_MAP, AuthType.NO_AUTH, ContentType.JSON, null, null);

		List<Map<String, String>> map_name = JsonPathValidator.readListMap(response, "$[*]['name','id']");

		latest_map = map_name.get(0).get("id");

	}

	@Test
	public void deleteMarkerTest() throws IOException {

		// Create the Marker
		File teamfile = new File("./src/test/resources/jsons/CreateMarker");

		String content = Files.readString(teamfile.toPath());

		content = content.replace("{{id}}", GenerateUUID.getUUID());
		content = content.replace("{{map_id}}", latest_map);
		Response response = restclient.post(BASE_URL_FM, CREATE_MARKER_ENDPOINT, content, AuthType.API_KEY,
				ContentType.JSON);

		String markerid = JsonPathValidator.read(response, "$.result[0]");

		// Delete Marker

		String delete_Marker = "{\n" + "  \"id\": 12345,\n" + "  \"jsonrpc\": \"2.0\",\n"
				+ "  \"method\": \"deleteMarkers\",\n" + "  \"params\": {\n" + "    \"ids\": [\n" + "      \""
				+ markerid + "\"\n" + "    ],\n" + "    \"map_id\": \"" + latest_map + "\"\n" + "  }\n" + "}";

		System.out.println(delete_Marker);

		Response responsedel = restclient.post(BASE_URL_FM, CREATE_MARKER_ENDPOINT, delete_Marker, AuthType.API_KEY,
				ContentType.JSON);

		Object val = responsedel.jsonPath().getInt("result.deleted");

		Assert.assertEquals(val, 1);
	}

}
