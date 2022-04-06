package com.amin.gestiondestock.dto;

import java.util.List;
import com.amin.gestiondestock.model.Article;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {
	
	private Integer id;

	private String code;
	
	private String designation;
	
	private List<Article> articles;
}
