package com.qa.api.utils;

import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import io.restassured.response.Response;

public class JsonPathValidator {

	private static ReadContext getcontext(Response response) {
		return JsonPath.parse(response.asString());
	}

	public static <T> T read(Response response, String jsonpath) {
		return getcontext(response).read(jsonpath);

	}

	public static <T> List<T> readList(Response response, String jsonpath) {
		return getcontext(response).read(jsonpath);

	}

	public static <T> List<Map<T, T>> readListMap(Response response, String jsonpath) {
		return getcontext(response).read(jsonpath);

	}

}
