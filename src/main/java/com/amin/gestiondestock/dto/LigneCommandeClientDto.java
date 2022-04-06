package com.amin.gestiondestock.dto;

import java.math.BigDecimal;
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
}
