package com.qa.api.contacts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.utils.ContactsAPIToken;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetContactsAPITest extends BaseTest {

	@BeforeMethod
	public void getTokenID() {
		ContactsAPIToken.contactsAPIToken("rob@motors.com", "Canada@123");

	}

	@Test
	public void getAllContactsTest() {

		Response responseGet = restclient.get(BASE_URL_CONTACTS, CONTACTS_LOGIN_ENDPOINT, AuthType.BEARER_TOKEN,
				ContentType.JSON, null, null);

		Assert.assertTrue(responseGet.statusLine().contains("OK"));

		List<String> id = responseGet.jsonPath().getList("_id");
		System.out.println(id);
		System.out.println(id.size());

	}

	@Test
	public void getContactsWithQueryParameter() {

		Map<String, String> queryParameter = new HashMap<>();

		queryParameter.put("stateProvince", "KS");

		Response responseGet = restclient.get(BASE_URL_CONTACTS, CONTACTS_LOGIN_ENDPOINT, AuthType.BEARER_TOKEN,
				ContentType.JSON, null, queryParameter);

		String jsonResponse = responseGet.asString();

		ReadContext ctx = JsonPath.parse(jsonResponse);

		System.out.println("=======================================================================================");

		// List <String> countries = ctx.read("$[?(@.country =='USA')]")

		List<Map<String, String>> maps = ctx.read("$[?(@.country =='USA')]['_id','firstName']");
//		System.out.println(maps);
		
		for (Map<String, String> a : maps) {
			
			
			System.out.println("The Person  "+a.get("firstName") + "  lives in USA " + "with the client id " + a.get("_id"));	
		}
		
		

	}

}
