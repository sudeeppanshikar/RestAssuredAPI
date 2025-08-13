package com.qa.api.base;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.qa.api.client.RestClient;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

public class BaseTest {

	protected RestClient restclient;

	// *********************APIBASEURL*********************//

	protected final static String BASE_URL_GOREST = "https://gorest.co.in";
	protected final static String BASE_URL_CONTACTS = "https://thinking-tester-contact-list.herokuapp.com";
	protected final static String BASE_URL_PRODUCT = "https://fakestoreapi.com";
	protected final static String BASE_URL_AMEDUS = "https://test.api.amadeus.com";
	protected final static String BASE_URL_FM = "https://dev-vm-test-tc3-04/api/fleet";

	// *********************API ENDPOINT*********************//

	protected final static String GOREST_USERS_ENDPOINT = "/public/v2/users";
	protected final static String GOREST_USERS_ENDPOINT_PATHPARAMETER = "/public/v2/users/{userid}"; 
	protected final static String CONTACTS_LOGIN_ENDPOINT = "/contacts";
	protected final static String PRODUCTS_ENDPOINT = "/products";
	protected final static String AMEDUS_ENDPOINT = "/v1/security/oauth2/token";
	protected final static String AMADEUS_FLIGHT_DEST_ENDPOINT = "/v1/shopping/flight-destinations";
	protected final static String GET_MAP = "/v2/maps/"; 
	protected final static String CREATE_TEAM = "/v2/operations/";
	protected final static String GET_TEAM = "/v2/teams/";
	protected final static String CREATE_MARKER_ENDPOINT = "/v2/maps/operations/";
	protected final static String GET_MARKER_ENDPOINT = "/v2/maps/markers/";
	@BeforeSuite
	public void setupAllureReports() {
		RestAssured.filters(new AllureRestAssured());
	}
	
	
	@BeforeTest
	public void setup() {
		restclient = new RestClient();
	}

}
