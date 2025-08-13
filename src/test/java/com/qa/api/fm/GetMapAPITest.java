package com.qa.api.fm;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.utils.JsonPathValidator;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetMapAPITest extends BaseTest {

	@BeforeClass
	public void relaxhttps() {
		RestAssured.useRelaxedHTTPSValidation();
	}

	@Test
	public void getMapIDTest() {

		Map<String, String> page = new HashMap<String, String>();

		page.put("page", "1");
		page.put("limit", "3");

		System.out.println(page);

		Response response = restclient.get(BASE_URL_FM, GET_MAP, AuthType.NO_AUTH, ContentType.JSON, null, page);

		// List<Map<String, String>> map_name = JsonPathValidator.readListMap(response,
		// "$[*]['name','id']");
		// List<Map<String, String>> map_name = JsonPathValidator.readListMap(response,
		// "$.results[*]");

		DocumentContext dx = JsonPath.parse(response.asString());

		List<Map<String, String>> map_name = dx.read("$.results[*]");

		System.out.println(map_name.size());
		System.out.println(map_name);

		System.out.println(response.header("Transfer-Encoding"));

		List<String> created_date = JsonPathValidator.readList(response, "$.results[*].created");



		System.out.println(OffsetDateTime.parse("2025-08-07T19:19:05.122422Z"));
		
		/*
		 * System.out.println(response.statusCode());
		 * System.out.println(map_name.get(0));
		 * 
		 * 
		 * String latest_map = map_name.get(0).get("id");
		 * System.out.println(latest_map);
		 */

		/*
		 * for (Map<String, String> a : map_name) {
		 * 
		 * String mapname = a.get("name"); String mapid = a.get("id");
		 * 
		 * System.out.println(mapname + " " + mapid);
		 * 
		 * }
		 */

	}

}
