package com.tanvir.product.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CategoryAlredyExixtsException extends RuntimeException {
	
	public CategoryAlredyExixtsException(String message) {
		super(message);
		
	}

}
