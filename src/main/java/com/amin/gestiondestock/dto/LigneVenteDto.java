package com.amin.gestiondestock.dto;

import java.math.BigDecimal;

import com.amin.gestiondestock.model.Article;
import com.amin.gestiondestock.model.LigneVente;
import com.amin.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneVenteDto {
	
	private Integer id;

	private VentesDto vente;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;

	private ArticleDto article;
	
	public static LigneVenteDto fromEntity(LigneVente ligneVente) {
		if (ligneVente == null) {
			return null;
		}
		
		return LigneVenteDto.builder()
				.id(ligneVente.getId())
				.vente(VentesDto.fromEntity(ligneVente.getVente()))
				.article(ArticleDto.fromEntity(ligneVente.getArticle()))
				.quantite(ligneVente.getQuantite())
				.prixUnitaire(ligneVente.getPrixUnitaire())
				.build();
	}
	
	public static LigneVente toEtity(LigneVenteDto ligneVenteDto) {
		if (ligneVenteDto == null) {
			return null;
		}
		
		LigneVente ligneVente = new LigneVente();
		ligneVente.setId(ligneVenteDto.getId());
		ligneVente.setVente(VentesDto.toEtity(ligneVenteDto.getVente()));
		ligneVente.setQuantite(ligneVenteDto.getQuantite());
		ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.getArticle()));
		ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
		
		return ligneVente;
	}
}
