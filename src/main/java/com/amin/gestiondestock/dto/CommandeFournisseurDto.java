package com.amin.gestiondestock.dto;

import java.time.Instant;
import java.util.List;
import com.amin.gestiondestock.model.Fournisseur;

public class CommandeFournisseurDto {
	
	private Integer id;

	private String code;

	private Instant dateCommande;
	
	private Fournisseur fournisseur;
	
	private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;
}
