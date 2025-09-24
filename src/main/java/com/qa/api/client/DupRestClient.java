package com.qa.api.client;

import com.github.tomakehurst.wiremock.http.Body;
import com.qa.api.constants.AuthType;
import com.qa.api.manager.ConfigManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class DupRestClient {

	private ResponseSpecification responseSpec404 = RestAssured.expect().statusCode(404);

	private RequestSpecification requestSpec(String baseuri, ContentType contenttype, AuthType authtype) {

		RequestSpecification request = RestAssured.given().log().all().baseUri(baseuri).contentType(contenttype)
				.accept(contenttype);

		switch (authtype) {
		case BEARER_TOKEN:
			request.headers("Authoriation", "Bearer " + ConfigManager.get("bearertoken"));
			break;

		default:
			break;
		}

		return request;

	}

	public Response post(String baseuri, ContentType contenttype, AuthType authtype, Body T, String endpoint) {

		RequestSpecification request = requestSpec(baseuri, contenttype, authtype);
		Response response = request.body(T).post(endpoint).then().spec(responseSpec404).extract().response();
		response.prettyPrint();
		return response;

	}

}
