package com.tanvir.product.service;

import org.springframework.stereotype.Service;

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
		
		Category category= categoryRepository.findById(productDTO.getCategoryId())
				.orElseThrow(()	-> new RuntimeException("Category not found"));
		
		// DTO -> Entity
	    Product product=ProductMapper.toProductEntity(productDTO, category);
	   product= productRepository.save(product);
	   
	   // Entity -> DTO
	   
	  return ProductMapper.toProductDto(product);
		
	}

}
