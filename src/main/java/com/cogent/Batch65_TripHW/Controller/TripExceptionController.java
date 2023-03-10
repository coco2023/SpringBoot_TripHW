package com.cogent.Batch65_TripHW.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TripExceptionController {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult()	.getAllErrors()	.forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMesg = error.getDefaultMessage()	;
			errors.put(fieldName, errorMesg);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);		
	}

	public ResponseEntity<Object> handleNoSuchExceptions(MethodArgumentNotValidException ex){
		 Map<String, String> errors = new HashMap<>();
		 ex.getBindingResult().getAllErrors().forEach((error) -> {
		 String fieldName = ((FieldError) error).getField();
		 String errorMessage = error.getDefaultMessage();
		 errors.put(fieldName, errorMessage);
		 });
			return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleRuntimeException(RuntimeException ex){
		return new ResponseEntity<Object>("An erroroccurred: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

		 	
}
