package com.matrimony.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matrimony.exception.MatrimonyDetailNotfoundException;

@ControllerAdvice
public class MatrimonyExceptionController {
	@ExceptionHandler(value = MatrimonyDetailNotfoundException.class)
	   public ResponseEntity<Object> exception(MatrimonyDetailNotfoundException exception) {
	      return new ResponseEntity<>("Matrimony login user not found", HttpStatus.NOT_FOUND);
	   }
}
