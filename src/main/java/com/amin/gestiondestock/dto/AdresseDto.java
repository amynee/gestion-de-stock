package com.amin.gestiondestock.dto;

import javax.persistence.Column;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDto {

	private String adresse1;
	
	private String adresse2;
	
	private String ville;
	
	private String codePostale;
	
	private String pays;
}
