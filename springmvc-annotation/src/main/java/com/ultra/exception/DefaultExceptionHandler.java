package com.ultra.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RestControllerAdvice
public class DefaultExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

	@ExceptionHandler(IllegalArgumentException.class)
	public String illegalException(IllegalArgumentException exception) {
		logger.error("", exception);
		return "400";

	}
}
