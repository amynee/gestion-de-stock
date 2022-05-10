package com.amin.gestiondestock.dto;

import java.math.BigDecimal;

import com.amin.gestiondestock.model.LigneCommandeClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeClientDto {

	private Integer id;
	
	private ArticleDto article;
	
	private CommandeClientDto commandesClient;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient) {
		if (ligneCommandeClient == null) {
			return null;
		}
		
		return LigneCommandeClientDto.builder()
				.id(ligneCommandeClient.getId())
				.quantite(ligneCommandeClient.getQuantite())
				.prixUnitaire(ligneCommandeClient.getPrixUnitaire())
				.commandesClient(CommandeClientDto.fromEntity(ligneCommandeClient.getCommandesClient()))
				.article(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))
				.build();
	}
	
	public static LigneCommandeClient toEtity(LigneCommandeClientDto ligneCommandeClientDto) {
		if (ligneCommandeClientDto == null) {
			return null;
		}
		
		LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
		ligneCommandeClient.setId(ligneCommandeClientDto.getId());
		ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
		ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
		ligneCommandeClient.setCommandesClient(CommandeClientDto.toEtity(ligneCommandeClientDto.getCommandesClient()));
		ligneCommandeClient.setArticle(ArticleDto.toEntity(ligneCommandeClientDto.getArticle()));
		
		return ligneCommandeClient;
	}
}
