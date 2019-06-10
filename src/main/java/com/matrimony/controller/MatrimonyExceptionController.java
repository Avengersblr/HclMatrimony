package com.matrimony.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matrimony.exception.MatrimonyApplicationException;

@ControllerAdvice
public class MatrimonyExceptionController {
	@ExceptionHandler(value = MatrimonyApplicationException.class)
	   public ResponseEntity<Object> exception(MatrimonyApplicationException exception) {
	      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	   }
}
