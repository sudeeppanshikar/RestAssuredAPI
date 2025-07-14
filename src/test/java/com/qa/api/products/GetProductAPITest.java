package com.qa.api.products;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.pojo.ProductAPI;
import com.qa.api.utils.JsonUtilMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetProductAPITest extends BaseTest {

	@Test

	public void getAllProductTest() {

		Response responseGet = restclient.get(BASE_URL_PRODUCT, PRODUCTS_ENDPOINT, AuthType.NO_AUTH, ContentType.JSON,
				null, null);

		ProductAPI[] product = JsonUtilMapper.deserialize(responseGet, ProductAPI[].class);
		
		for (ProductAPI p : product) {
			
			if (p.getId()==1) {
			System.out.println("id: " + p.getId() );
			System.out.println("title: " + p.getTitle() );
			System.out.println("price: " + p.getPrice() );
			System.out.println("description: " + p.getDescription() );
			System.out.println("category: " + p.getCategory() );
			System.out.println("image: " + p.getImage() );
			System.out.println("rate: " + p.getRating().getRate() );
			System.out.println("count: " + p.getRating().getCount() );
			}
		}

	}

}
