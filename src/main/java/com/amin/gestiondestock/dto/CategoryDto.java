package com.amin.gestiondestock.dto;

import java.util.List;
import com.amin.gestiondestock.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryDto {
	
	private Integer id;

	private String code;
	
	private String designation;

	private Integer idEntreprise;
	
	@JsonIgnore
	private List<ArticleDto> articles;
	
	public static CategoryDto fromEntity(Category category) {
		System.out.println(category);
		if (category == null) {
			// TODO throw an exception
			return null;
		}
		
		return CategoryDto.builder()
				.id(category.getId())
				.code(category.getCode())
				.designation(category.getDesignation())
				.idEntreprise(category.getIdEntreprise())
				.build();
	}
	
	public static Category toEntity(CategoryDto categoryDto) {
		System.out.println(categoryDto);
		if (categoryDto == null) {
			// throw exception 
			return null;
		}
		
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setCode(categoryDto.getCode());
		category.setDesignation(categoryDto.getDesignation());
		category.setIdEntreprise(categoryDto.getIdEntreprise());
		return category;
	}

}
