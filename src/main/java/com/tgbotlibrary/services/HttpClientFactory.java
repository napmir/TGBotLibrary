package com.tgbotlibrary.services;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientFactory {

	private HttpClientFactory() {
	}

	/**
	 * <p>
	 * createHttpClient.
	 * </p>
	 *
	 * @return a {@link org.apache.http.client.HttpClient} object.
	 */
	public static HttpClient createHttpClient() {
		return HttpClientBuilder.create().build();
	}

}
