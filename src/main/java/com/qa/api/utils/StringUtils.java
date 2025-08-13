package com.qa.api.utils;

import java.util.Random;

public class StringUtils {
	
	public static String getRandomemailid() {
		return "apiautomation" + System.currentTimeMillis() + "@opencart.com";

	}
	
	public static String randomvalue() {

		Random random = new Random();
		return String.valueOf(random.nextInt(100));

	}

	public static String randomString() {

		Random random = new Random();
		return "Team" + random.nextInt();

	}

}


