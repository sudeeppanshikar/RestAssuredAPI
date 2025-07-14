package com.qa.api.manager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static Properties properties = new Properties();

	static {

		InputStream ip = ConfigManager.class.getClassLoader().getResourceAsStream("config/config.properties");
		if (ip != null) {
			try {
				properties.load(ip);
				System.out.println(properties);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static String get(String key) {
		return properties.getProperty(key).trim();

	}

	public static void set(String key, String value) {

		properties.setProperty(key, value.trim());

	}

}
