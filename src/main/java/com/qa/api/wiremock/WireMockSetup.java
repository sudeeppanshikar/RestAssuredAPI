package com.qa.api.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class WireMockSetup {
	
	private static WireMockServer server;

	public static void startWireMockeServer() {
		server = new WireMockServer(8080);
		WireMock.configureFor("localhost", 8080);
		server.start();
	}

	public static void stopWireMockServer() {
		server.stop();
	}

}
