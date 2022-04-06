package com.amin.gestiondestock.dto;

import java.time.Instant;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MvtStkDto {
	
	private Integer id;
	
	private Instant dateMvt;
	
	private Instant quantite;

	private ArticleDto article;
	
	private TypeMvtStkDto typeMvt;
}
