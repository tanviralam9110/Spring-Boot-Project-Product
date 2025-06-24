package com.tanvir.product.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanvir.product.dto.ProductDTO;
import com.tanvir.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	
	private ProductService productService;
	
	@Autowired
	 public ProductController(ProductService productService) {
	        this.productService = productService;
	    }
	
	//get product
	//create product
	
	@PostMapping
	public ProductDTO createProduct(@RequestBody ProductDTO  productDTO) {
		return productService.createProduct(productDTO);
		
	}
	//update product
	//get product by id
	// delete product

}
