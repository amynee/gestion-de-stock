package com.amin.gestiondestock.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.amin.gestiondestock.exception.EntityNotFoundException;
import com.amin.gestiondestock.exception.InvalidEntityException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorDto> handleExcception(EntityNotFoundException exception, WebRequest webRequest) {
		
		final HttpStatus notFound = HttpStatus.NOT_FOUND;
		final ErrorDto errorDto = ErrorDto.builder()
				.code(exception.getErrorCode())
				.httpCode(notFound.value())
				.message(exception.getMessage())
				.build();
		
		return new ResponseEntity<>(errorDto, notFound);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ErrorDto> handleExcception(InvalidEntityException exception, WebRequest webRequest) {
		
		final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		final ErrorDto errorDto = ErrorDto.builder()
				.code(exception.getErrorCode())
				.httpCode(badRequest.value())
				.message(exception.getMessage())
				.errors(exception.getErrors())
				.build();
		
		return new ResponseEntity<>(errorDto, badRequest);
	}
}
