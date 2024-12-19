package com.raghu.exceptionhandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ ValidationFailException.class })
	public ResponseEntity<?> validationFailException(ValidationFailException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setDescritpion(ex.getMessage());
		error.setLocalDateTime(LocalDateTime.now());
		error.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ ResourceNotFoundException.class })
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setDescritpion(ex.getMessage());
		error.setLocalDateTime(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

}
