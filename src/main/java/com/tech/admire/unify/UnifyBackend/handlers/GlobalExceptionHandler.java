package com.tech.admire.unify.UnifyBackend.handlers;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tech.admire.unify.UnifyBackend.models.ErrorModel;
import com.tech.admire.unify.UnifyBackend.models.GenericResponse;
import com.tech.admire.unify.UnifyBackend.utils.ResponseBuilder;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public GenericResponse handleUnAuthorizedError(Exception ex) {
		log.error("Error: ", ex);
		ErrorModel error = new ErrorModel();
		StringWriter e = new StringWriter();
		ex.printStackTrace(new PrintWriter(e));
		error.setDetails(e.toString());
		error.setMessage(ex.getMessage());
		log.error("Error: {}", ex.getLocalizedMessage());
		return ResponseBuilder.generateResponse(error, false);
	}

}
