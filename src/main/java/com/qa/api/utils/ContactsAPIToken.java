package com.qa.api.utils;


import com.qa.api.client.RestClient;
import com.qa.api.constants.AuthType;
import com.qa.api.manager.ConfigManager;
import com.qa.api.pojo.ContactsAPILoginToken;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ContactsAPIToken {

	
	public static  void contactsAPIToken(String login, String password) {
		
		RestClient restclient = new RestClient();
		
		ContactsAPILoginToken contactToken = ContactsAPILoginToken.builder().email(login)
		.password(password).build();
	
		Response response = restclient.post("https://thinking-tester-contact-list.herokuapp.com", "/users/login", contactToken, AuthType.NO_AUTH, ContentType.JSON);

		String tokenid = response.jsonPath().getString("token");
		
		
		ConfigManager.set("bearertoken",tokenid);
		
	//	System.out.println(ConfigManager.get("bearertoken"));
		
		
	}
	
}
