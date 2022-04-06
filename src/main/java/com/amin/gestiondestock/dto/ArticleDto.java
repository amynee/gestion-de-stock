package com.amin.gestiondestock.dto;
import com.amin.gestiondestock.model.Category;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class ArticleDto {
	
	private Integer id;
	
	private String codeArticle;
	
	private String designation;
	
	private String prixUnitaireHt;
	
	private BigDecimal tauxTva;
	
	private BigDecimal prixUnitaireTtc;
	
	private String photo;
	
	private CategoryDto category;
}
