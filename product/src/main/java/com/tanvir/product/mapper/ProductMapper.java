package com.tanvir.product.mapper;

import com.tanvir.product.dto.ProductDTO;
import com.tanvir.product.entity.Category;
import com.tanvir.product.entity.Product;

public class ProductMapper {
	
	// entity to dto
	
	public static ProductDTO toProductDto(Product product) {
		
		return new ProductDTO(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getPrice(),
				product.getCategory().getId()
				
				);
	    }
	
	//dto t entity
	
	public static Product toProductEntity(ProductDTO productDTO, Category category) {
		
		Product product=new Product();
		
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setCategory(category);
		
		return product;
		
	}

}
