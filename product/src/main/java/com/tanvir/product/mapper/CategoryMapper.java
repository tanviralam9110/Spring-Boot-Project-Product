package com.tanvir.product.mapper;

import com.tanvir.product.dto.CategoryDTO;
import com.tanvir.product.entity.Category;

public class CategoryMapper {
	
	public static CategoryDTO toCategoryDto(Category category) {
		if(category==null) {
			return null;
		}
		CategoryDTO  categoryDTO=new CategoryDTO();
		
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		categoryDTO.setProductDTOs(category.getProducts().stream()
				.map(ProductMapper :: toProductDto).toList());
		return categoryDTO;
	}
	
	public static Category toCategoryEntity(CategoryDTO categoryDTO) {
		Category category=new Category();
		category.setName(categoryDTO.getName());
		return category;
	}

}
