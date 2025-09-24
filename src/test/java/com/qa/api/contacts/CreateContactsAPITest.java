package com.qa.api.contacts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.pojo.ContactsAPIAddContact;
import com.qa.api.utils.ContactsAPIToken;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateContactsAPITest extends BaseTest {

	String id = null;
	Response responseGet = null;

	@BeforeClass
	public void getTokenID() {
		ContactsAPIToken.contactsAPIToken("rob@motors.com", "Canada@123");

	}

	@Test(priority = 1)
	public void createContactThroughPojoTest() {

		// create Contacts
		ContactsAPIAddContact contacts = ContactsAPIAddContact.builder().firstName("Varun").lastName("Pradhan")
				.birthdate("1980-01-01").email("ms11@gmail.com").phone("8005555555").street1("fox street")
				.street2("Jackal lane").city("kensas").stateProvince("kingdom").postalCode("626262").country("USA")
				.build();

		Response responsePost = restclient.post(BASE_URL_CONTACTS, CONTACTS_LOGIN_ENDPOINT, contacts,
				AuthType.BEARER_TOKEN, ContentType.JSON);
		Assert.assertTrue(responsePost.statusLine().contains("Created"));

		id = responsePost.jsonPath().getString("_id");

		/*
		 * contacts.set_id(id);
		 * 
		 * 
		 * // get contacts
		 * 
		 * responseGet = restclient.get(BASE_URL_CONTACTS, CONTACTS_LOGIN_ENDPOINT + "/"
		 * + id, AuthType.BEARER_TOKEN, ContentType.JSON, null, null);
		 * Assert.assertTrue(responseGet.statusLine().contains("OK"));
		 */

	
		
	}

	@Test(priority = 2)

	public void patchContactsCall() {
		// Patch Contacts

		ContactsAPIAddContact contactsPatch = new ContactsAPIAddContact();
		contactsPatch.setFirstName("Vikas");
		contactsPatch.setEmail("linden@gmail.com");

		Response responsePatch = restclient.patch(BASE_URL_CONTACTS, CONTACTS_LOGIN_ENDPOINT + "/" + id, contactsPatch,
				AuthType.BEARER_TOKEN, ContentType.JSON);
		Assert.assertTrue(responsePatch.statusLine().contains("OK"));

		// get contacts
		responseGet = restclient.get(BASE_URL_CONTACTS, CONTACTS_LOGIN_ENDPOINT + "/" + id, AuthType.BEARER_TOKEN,
				ContentType.JSON, null, null);
		Assert.assertTrue(responseGet.statusLine().contains("OK"));
		Assert.assertEquals(responseGet.jsonPath().getString("firstName"), contactsPatch.getFirstName());
	}

}
