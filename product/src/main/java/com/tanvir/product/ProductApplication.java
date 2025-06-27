package com.tanvir.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
		info = @Info(
				title = "Product Service REST  API Documentation",
				description = "Product Service REST API",
				version = "V1",
				contact = @Contact(
						name = "Md Tanvir Alam",
						email = "tanviralam3524@gmail.com"
						)
				
				))


@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
