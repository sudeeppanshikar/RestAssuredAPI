package com.qa.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class JsonUtilMapper {

	public static  <T> T deserialize(Response response, Class<T> targetclass) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.readValue(response.getBody().asString(), targetclass);
		} catch (Exception e) {

			throw new RuntimeException("Failed" + targetclass.getClass());
		}

	}

}
