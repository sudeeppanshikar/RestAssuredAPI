package com.qa.api.client;

import static org.testng.Assert.expectThrows;

import java.io.File;
import java.util.Map;

import static org.hamcrest.Matchers.*;

import com.qa.api.constants.AuthType;
import com.qa.api.exceptions.APIException;
import com.qa.api.manager.ConfigManager;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestClient {

	private ResponseSpecification responseSpec200 = RestAssured.expect().statusCode(200);
	private ResponseSpecification responseSpec201 = RestAssured.expect().statusCode(201);
	private ResponseSpecification responseSpec204 = RestAssured.expect().statusCode(204);
	private ResponseSpecification responseSpec400 = RestAssured.expect().statusCode(400);
	private ResponseSpecification responseSpec404 = RestAssured.expect().statusCode(404);
	private ResponseSpecification responseSpec200or201or404 = RestAssured.expect()
			.statusCode(anyOf(equalTo(200), equalTo(201), equalTo(404)));

	private RequestSpecification setupRequest(String baseUrl, AuthType authType, ContentType contentType) {

		RequestSpecification request = RestAssured.given().log().all().baseUri(baseUrl).contentType(contentType)
				.accept(contentType);

		switch (authType) {
		case BEARER_TOKEN:
			request.headers("Authorization", "Bearer " + ConfigManager.get("bearertoken"));
			break;

		case BASIC_AUTH:
			request.headers("Authorization", "Basic" + "==BasicAuth==");
			break;

		case API_KEY:
			request.headers("Authorization", "Api-Key " + ConfigManager.get("apikey"));
			break;

		case NO_AUTH:
			System.out.println("No auth Required");
			break;

		default:
			System.out.println("Please enter the correct auth");
			throw new APIException("==InvalidAuth==");

		}

		return request;
	}

	private void applyParams(RequestSpecification request, Map<String, String> pathParameter,
			Map<String, String> queryParameter) {

		if (pathParameter != null) {
			request.pathParams(pathParameter);
		}

		if (queryParameter != null) {
			request.queryParams(queryParameter);
		}
	}

	// CRUD

	/**
	 * 
	 * @param baseUrl
	 * @param endpoint
	 * @param authType
	 * @param contentType
	 * @param pathParameter
	 * @param queryParameter
	 * @return Response Generic Get call for CRUD operation
	 */

	public Response get(String baseUrl, String endpoint, AuthType authType, ContentType contentType,
			Map<String, String> pathParameter, Map<String, String> queryParameter) {

		RequestSpecification request = setupRequest(baseUrl, authType, contentType);
		applyParams(request, pathParameter, queryParameter);
		Response response = request.get(endpoint).then().spec(responseSpec200or201or404).extract().response();
		response.prettyPrint();
		return response;
	}

	// oauth post
	
	/**
	 * @param baseUrl
	 * @param endpoint
	 * @param authType
	 * @param contentType
	 * @param granttype
	 * @param clientid
	 * @param clientsecret
	 * @return
	 */
	public Response post(String baseUrl, String endpoint, AuthType authType, ContentType contentType, String granttype,
			String clientid, String clientsecret) {

		RequestSpecification request = setupRequest(baseUrl, authType, contentType);
		Response response = request.formParam("grant_type", granttype).formParam("client_id", clientid)
				.formParam("client_secret", clientsecret).post(endpoint).then().spec(responseSpec200or201or404)
				.extract().response();
		response.prettyPrint();
		return response;
	}

	// post

	/**
	 * 
	 * @param <T>
	 * @param baseUrl
	 * @param endpoint
	 * @param body
	 * @param authType
	 * @param contentType
	 * @return
		 */
		public <T> Response post(String baseUrl, String endpoint, T body, AuthType authType, ContentType contentType) {
	
			RequestSpecification request = setupRequest(baseUrl, authType, contentType);
	
			Response response = request.body(body).post(endpoint).then().spec(responseSpec200or201or404).extract()
					.response();
			response.prettyPrint();
		return response;

	}

	/**
	 * 
	 * @param baseUrl
	 * @param endpoint
	 * @param fileType
	 * @param authType
	 * @param contentType
	 * @return
	 */

	public Response post(String baseUrl, String endpoint, File fileType, AuthType authType, ContentType contentType) {

		RequestSpecification request = setupRequest(baseUrl, authType, contentType);

		Response response = request.body(fileType).post(endpoint).then().spec(responseSpec200or201or404).extract().response();
		response.prettyPrint();
		return response;

	}

	public <T> Response put(String baseUrl, String endpoint, T body, AuthType authType, ContentType contentType) {

		RequestSpecification request = setupRequest(baseUrl, authType, contentType);

		Response response = request.body(body).put(endpoint).then().spec(responseSpec200).extract().response();
		response.prettyPrint();
		return response;

	}

	public <T> Response patch(String baseUrl, String endpoint, T body, AuthType authType, ContentType contentType) {

		RequestSpecification request = setupRequest(baseUrl, authType, contentType);

		Response response = request.body(body).patch(endpoint).then().spec(responseSpec200).extract().response();
		response.prettyPrint();
		return response;

	}

	public Response delete(String baseUrl, String endpoint, AuthType authType, ContentType contentType) {

		RequestSpecification request = setupRequest(baseUrl, authType, contentType);

		Response response = request.delete(endpoint).then().spec(responseSpec204).extract().response();
		response.prettyPrint();
		return response;

	}

}
