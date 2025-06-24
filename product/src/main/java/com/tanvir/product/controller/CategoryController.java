package com.tanvir.product.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanvir.product.dto.CategoryDTO;
import com.tanvir.product.service.CategoryService;

import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
	
	private CategoryService  categoryService;
	
	// get all categories
	
	//create categories
	
	@PostMapping
	public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.createCategory(categoryDTO);
		
	}
	//get category by id
	
	// delete category
	

}
