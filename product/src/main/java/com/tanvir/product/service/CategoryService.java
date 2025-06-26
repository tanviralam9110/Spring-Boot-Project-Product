package com.tanvir.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tanvir.product.Exception.CategoryAlredyExixtsException;
import com.tanvir.product.dto.CategoryDTO;
import com.tanvir.product.entity.Category;
import com.tanvir.product.mapper.CategoryMapper;
import com.tanvir.product.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {

	public CategoryRepository categoryRepository;

	// create category

	public CategoryDTO createCategory(CategoryDTO categoryDTO) {

		Optional<Category> optionalCategory = categoryRepository.findByName(categoryDTO.getName());

		if (optionalCategory.isPresent()) {
			throw new CategoryAlredyExixtsException("Category " + categoryDTO.getName() + " alredy exists!");
		}
		Category category = CategoryMapper.toCategoryEntity(categoryDTO);
		category = categoryRepository.save(category);
		return CategoryMapper.toCategoryDto(category);
	}

	// get all category

	public List<CategoryDTO> getAllCategories() {
		return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDto).toList();
	}

	// get category by id

	public CategoryDTO getCategoryById(Long id) {

		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category Id is not found"));
		return CategoryMapper.toCategoryDto(category);
	}
	// delete category

	public String deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		return "Category " + id + " has been deleted!!";
	}

}
