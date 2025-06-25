package com.tanvir.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tanvir.product.dto.ProductDTO;
import com.tanvir.product.entity.Category;
import com.tanvir.product.entity.Product;
import com.tanvir.product.mapper.ProductMapper;
import com.tanvir.product.repository.CategoryRepository;
import com.tanvir.product.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;

	public ProductDTO createProduct(ProductDTO productDTO) {

		Category category = categoryRepository.findById(productDTO.getCategoryId())
				.orElseThrow(() -> new RuntimeException("Category not found"));

		// DTO -> Entity
		Product product = ProductMapper.toProductEntity(productDTO, category);
		product = productRepository.save(product);

		// Entity -> DTO

		return ProductMapper.toProductDto(product);

	}

	// Get All Products

	public List<ProductDTO> getAllProduct() {

		return productRepository.findAll().stream().map(ProductMapper::toProductDto).toList();
	}

	// Get Product By Id

	public ProductDTO getProductById(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product is not Found"));
		return ProductMapper.toProductDto(product);

	}

	// Update Product

	public ProductDTO updateProduct(Long id, ProductDTO productDTO) {

		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product is not Found"));
		Category category = categoryRepository.findById(productDTO.getCategoryId())
				.orElseThrow(() -> new RuntimeException("Category is not Found"));

		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product. setPrice(productDTO.getPrice());
		product.setCategory(category);
		productRepository.save(product);
		return ProductMapper.toProductDto(product);
	}
	
	// product Deleted
	
	public String deleteProduct(Long id) {
		productRepository.deleteById(id);
		return "Product "+id+" has been deleted";
	}
	

}
