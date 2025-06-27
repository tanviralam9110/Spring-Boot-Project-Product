package com.tanvir.product.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
		name = "Category",
		description = "It hold's category information along with their product's"
		)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
	private long id;
	private String name;

	private List<ProductDTO> productDTOs;

}
