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

import com.tanvir.product.dto.CategoryDTO;
import com.tanvir.product.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
		name = "Category REST API CRUD Operation",
		description = "CREATE READ UPDATE and DELETE Opration for Category REST API"
		)

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

	private CategoryService categoryService;

	// get all categories
	
	@Operation(summary = "Fetch All Category ", 
			description = "REST API to fetch all catogories.")

	@GetMapping
	public List<CategoryDTO> getAllCategories() {
		return categoryService.getAllCategories();
	}

	// create categories
	
	@Operation(summary = "Create Category ", 
			description = "REST API to create catogories.")

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
	
	@Operation(summary = "Fetch  Category By Id ", 
			description = "REST API to fetch  catogories by id.")
	

	@GetMapping("/{id}")
	public CategoryDTO getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}

	// delete category
	@Operation(summary = "Delete Category By Id ", 
			description = "REST API to delete catogories By Id.")

	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable Long id) {
		return categoryService.deleteCategory(id);

	}

}
