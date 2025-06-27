package com.tanvir.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Schema(
		name = "Product",
		description = "It hold's products information "
		)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private Long id;
	private String name;
	private String description;
	private Double price;
	private Long CategoryId;

}
