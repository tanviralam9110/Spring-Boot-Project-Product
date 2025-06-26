package com.tanvir.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanvir.product.Exception.CategoryAlredyExixtsException;
import com.tanvir.product.dto.CategoryDTO;
import com.tanvir.product.service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

	private CategoryService categoryService;

	// get all categories

	@GetMapping
	public List<CategoryDTO> getAllCategories() {
		return categoryService.getAllCategories();
	}

	// create categories

	@PostMapping
	public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
		
//		try {
//			
//			CategoryDTO savedCategory=categoryService.createCategory(categoryDTO);
//			return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
//			
//		} catch (CategoryAlredyExixtsException exception) {
//			
//			return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
//		}
		
		CategoryDTO savedCategory=categoryService.createCategory(categoryDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);

	}
	// get category by id
	

	@GetMapping("/{id}")
	public CategoryDTO getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}

	// delete category

	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable Long id) {
		return categoryService.deleteCategory(id);

	}

}
