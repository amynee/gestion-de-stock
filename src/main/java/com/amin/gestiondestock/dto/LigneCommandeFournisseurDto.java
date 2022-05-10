package com.amin.gestiondestock.dto;

import java.math.BigDecimal;

import com.amin.gestiondestock.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {
	
	private Integer id;

	private ArticleDto article;
	
	private CommandeFournisseurDto commandesFournisseur;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
		if (ligneCommandeFournisseur == null) {
			return null;
		}
		
		return LigneCommandeFournisseurDto.builder()
				.id(ligneCommandeFournisseur.getId())
				.quantite(ligneCommandeFournisseur.getQuantite())
				.prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
				.article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
				.commandesFournisseur(CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandesFournisseur()))
				.build();
	}
	
	public static LigneCommandeFournisseur toEtity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
		if (ligneCommandeFournisseurDto == null) {
			return null;
		}
		
		LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
		ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
		ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDto.getQuantite());
		ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.getPrixUnitaire());
		ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(ligneCommandeFournisseurDto.getArticle()));
		ligneCommandeFournisseur.setCommandesFournisseur(CommandeFournisseurDto.toEtity(ligneCommandeFournisseurDto.getCommandesFournisseur()));
		
		return ligneCommandeFournisseur;
	}
}
