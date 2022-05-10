package com.amin.gestiondestock.dto;

import java.util.List;
import com.amin.gestiondestock.model.Category;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryDto {
	
	private Integer id;

	private String code;
	
	private String designation;
	
	private List<ArticleDto> articles;
	
	public static CategoryDto fromEntity(Category category) {
		if (category == null) {
			// TODO throw an exception
			return null;
		}
		
		return CategoryDto.builder()
				.id(category.getId())
				.code(category.getCode())
				.designation(category.getDesignation())
				.build();
	}
	
	public static Category toEntity(CategoryDto categoryDto) {
		if (categoryDto == null) {
			// throw exception 
			return null;
		}
		
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setCode(categoryDto.getCode());
		category.setDesignation(categoryDto.getDesignation());
		
		return category;
	}

}
