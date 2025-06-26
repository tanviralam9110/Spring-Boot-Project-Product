package com.tanvir.product.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tanvir.product.dto.ExceptionResponseDTO;

@ControllerAdvice
public class GlobleExceptionHandler {

	// Show on all details like apiPath message and time
	
	@ExceptionHandler(CategoryAlredyExixtsException.class)
	public ResponseEntity<ExceptionResponseDTO> handleCategoryAlredyExistsException(
			CategoryAlredyExixtsException exception, WebRequest webRequest) {

		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(webRequest.getDescription(false),
				HttpStatus.CONFLICT, 
				exception.getMessage(), 
				LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDTO);
	}
	
	// Show on all details like apiPath message and time
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ExceptionResponseDTO> handleCategoryNotFoundException(CategoryNotFoundException exception,
			WebRequest webRequest) {

		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(webRequest.getDescription(false),
				HttpStatus.NOT_FOUND, 
				exception.getMessage(), 
				LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDTO);
	}
	
	// Only Message can shown on ui
//	@ExceptionHandler(CategoryNotFoundException.class)
//	public ResponseEntity<String> handleCategoryNotFoundException(CategoryNotFoundException exception) {
//
//		return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
//	}
	
	
	//Handle all other exception
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponseDTO> handleGlobleException(Exception exception,
			WebRequest webRequest) {

		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(webRequest.getDescription(false),
				HttpStatus.INTERNAL_SERVER_ERROR, 
				exception.getMessage(), 
				LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponseDTO);
	}


}
