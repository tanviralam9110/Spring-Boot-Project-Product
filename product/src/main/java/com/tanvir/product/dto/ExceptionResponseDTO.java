package com.tanvir.product.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponseDTO {
	
	private String apiPath;
	private HttpStatus statusCode;
	private String errorMessage;
	private LocalDateTime errorTime;

}
