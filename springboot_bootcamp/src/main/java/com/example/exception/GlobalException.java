package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	//handle specific exception
	@ExceptionHandler(ResourceNotFound.class)
public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFound exception,
		WebRequest request)
{
	ErrorDetails erroeDetails=
new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

	return new ResponseEntity<>(erroeDetails,HttpStatus.NOT_FOUND);
}
	
}
