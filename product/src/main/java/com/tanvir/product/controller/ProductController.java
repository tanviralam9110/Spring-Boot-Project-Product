package com.tanvir.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanvir.product.dto.ProductDTO;
import com.tanvir.product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Product REST API CRUD Operation", description = "CREATE READ UPDATE and DELETE Opration for Product REST API")

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// create product

	@Operation(summary = "Create Product", description = "REST API to create product.")

	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
		ProductDTO createdProduct = productService.createProduct(productDTO);
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);

	}

	// get All product

	@Operation(summary = "Fetch All Product", description = "REST API to fetch all product.")

	@GetMapping
	public List<ProductDTO> getAllProduct() {
		return productService.getAllProduct();
	}

	// get product by id

	@Operation(summary = "Fetch Product By ID", description = "REST API to fetch product by id.")

	@GetMapping("/{id}")
	public ProductDTO getProductByid(@PathVariable Long id) {
		return productService.getProductById(id);

	}

	// update product

	@Operation(summary = "Update Product", description = "REST API to update product.")
	@PutMapping("/{id}")
	public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
		return productService.updateProduct(id, productDTO);

	}

	// delete product

	@Operation(summary = "Delete Product By Id", description = "REST API to delete product. by Id")

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		return productService.deleteProduct(id);

	}
}
