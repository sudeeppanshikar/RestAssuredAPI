package com.qa.api.products;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.utils.JsonPathValidator;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetProductAPIJsonTest extends BaseTest {

	@Test

	public void getProductAPIJsonTest() {

		Response responseGet = restclient.get(BASE_URL_PRODUCT, PRODUCTS_ENDPOINT, AuthType.NO_AUTH, ContentType.JSON,
				null, null);

		Object minprice = JsonPathValidator.read(responseGet, "min($[*].price)");
		System.out.println(minprice);
		
		List<Integer> ids = JsonPathValidator.readList(responseGet, "$[?(@.price>19)].id");
		System.out.println(ids);
		
		List<Map<Object,Object>> maps =   JsonPathValidator.readListMap(responseGet,  "$[?(@.price>19)]['id','category']");
		System.out.println(maps);
	
		for (Map<Object,Object> a : maps) {
			System.out.println(a.get("id"));
			System.out.println(a.get("category"));
			
		}

	

	}

}
