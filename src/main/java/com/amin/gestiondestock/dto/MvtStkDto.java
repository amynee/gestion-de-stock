package com.amin.gestiondestock.dto;

import java.time.Instant;

import com.amin.gestiondestock.model.MvtStk;

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
	
	public static MvtStkDto fromEntity(MvtStk mvtStk) {
		if (mvtStk == null) {
			return null;
		}
		
		return MvtStkDto.builder()
				.id(mvtStk.getId())
				.dateMvt(mvtStk.getDateMvt())
				.quantite(mvtStk.getQuantite())
				.article(ArticleDto.fromEntity(mvtStk.getArticle()))
				.build();
	}
	
	public static MvtStk toEtity(MvtStkDto mvtStkDto) {
		if (mvtStkDto == null) {
			return null;
		}
		
		MvtStk mvtStk = new MvtStk();
		mvtStk.setId(mvtStkDto.getId());
		mvtStk.setDateMvt(mvtStkDto.getDateMvt());
		mvtStk.setQuantite(mvtStkDto.getQuantite());
		mvtStk.setArticle(ArticleDto.toEntity(mvtStkDto.getArticle()));
		
		return mvtStk;
	}
}
