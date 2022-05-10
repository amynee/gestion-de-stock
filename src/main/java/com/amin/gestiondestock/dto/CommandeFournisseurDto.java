package com.amin.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import com.amin.gestiondestock.model.Client;
import com.amin.gestiondestock.model.CommandeClient;
import com.amin.gestiondestock.model.CommandeFournisseur;
import com.amin.gestiondestock.model.Fournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeFournisseurDto {
	
	private Integer id;

	private String code;

	private Instant dateCommande;
	
	private Fournisseur fournisseur;
	
	private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;
	
	public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
		if (commandeFournisseur == null) {
			return null;
		}
		
		return CommandeFournisseurDto.builder()
				.id(commandeFournisseur.getId())
				.code(commandeFournisseur.getCode())
				.dateCommande(commandeFournisseur.getDateCommande())
				.fournisseur(commandeFournisseur.getFournisseur())
				.build();
	}
	
	public static CommandeFournisseur toEtity(CommandeFournisseurDto commandeFournisseurDto) {
		if (commandeFournisseurDto == null) {
			return null;
		}
		
		CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
		commandeFournisseur.setId(commandeFournisseurDto.getId());
		commandeFournisseur.setCode(commandeFournisseurDto.getCode());
		commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
		commandeFournisseur.setFournisseur(commandeFournisseurDto.getFournisseur());
		
		return commandeFournisseur;
	}
}
