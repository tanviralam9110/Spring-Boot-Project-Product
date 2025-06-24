package com.tanvir.product.service;

import org.springframework.stereotype.Service;

import com.tanvir.product.dto.CategoryDTO;
import com.tanvir.product.entity.Category;
import com.tanvir.product.mapper.CategoryMapper;
import com.tanvir.product.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {
	
	public CategoryRepository categoryRepository;
	
	//create category
	
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category category=CategoryMapper.toCategoryEntity(categoryDTO);
		category=categoryRepository.save(category);
		 return CategoryMapper.toCategoryDto(category);
	}
	
	//get all category
	
	//get category by id
	//delete category
	
	

}
