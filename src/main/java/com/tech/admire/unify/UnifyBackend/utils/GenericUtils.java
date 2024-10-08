package com.tech.admire.unify.UnifyBackend.utils;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class GenericUtils {

	public static HttpHeaders buildApiHeaders(String authKey, String type) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", authKey);
		headers.set("Content-Type", type);
		return headers;
	}

	public static HttpHeaders buildApiHeadersSOAP(String authKey, MediaType type) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", authKey);
		headers.setContentType(type);
		return headers;
	}

	public static HttpHeaders buildApiHeadersJWT(String authHeader) {

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		return headers;
	}

	public static HttpHeaders buildApiHeadersAuth(String auth, MediaType mediaType) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", auth);
		headers.setAccept(Arrays.asList(mediaType));
		return headers;
	}

}
