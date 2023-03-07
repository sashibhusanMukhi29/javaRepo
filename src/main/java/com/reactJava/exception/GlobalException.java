package com.reactJava.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Map<String ,String>>customerNotFound(CustomerNotFoundException notFoundException)
	{
		Map<String,String>map= new HashMap<>();
		String message = notFoundException.getMessage();
		String localizedMessage = notFoundException.getLocalizedMessage();
		map.put(message, localizedMessage);
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
		
	}
			

}
