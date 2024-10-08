package com.tech.admire.unify.UnifyBackend.utils;

import java.time.Instant;

import com.tech.admire.unify.UnifyBackend.models.ErrorModel;
import com.tech.admire.unify.UnifyBackend.models.GenericResponse;

public class ResponseBuilder {

	private ResponseBuilder() {

	}

	public static GenericResponse generateResponse(Object data, boolean isSuccess) {
		GenericResponse response = new GenericResponse();
		response.setSuccess(isSuccess);
		response.setTimestamp(Instant.now());
		response.setData(data);
		return response;
	}

	public static GenericResponse generateResponse(ErrorModel error, boolean isSuccess) {
		GenericResponse response = new GenericResponse();
		response.setSuccess(isSuccess);
		response.setTimestamp(Instant.now());
		response.setError(error);
		return response;
	}

}
