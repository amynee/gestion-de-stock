package com.amin.gestiondestock.dto;

import java.util.List;
import com.amin.gestiondestock.model.Entreprise;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {
	
	private Integer id;
	
	private String nom;
	
	private String description;
	
	private AdresseDto adresse;
	
	private String codeFiscal;
	
	private String photo;
	
	private String email;
	
	private String numTel;
	
	private String steWeb;
	
	private List<UtilisateurDto> utilisateurs;
	
	public static EntrepriseDto fromEntity(Entreprise entreprise) {
		if (entreprise == null) {
			return null;
		}
		
		return EntrepriseDto.builder()
				.id(entreprise.getId())
				.nom(entreprise.getNom())
				.description(entreprise.getDescription())
				.codeFiscal(entreprise.getCodeFiscal())
				.photo(entreprise.getPhoto())
				.steWeb(entreprise.getSteWeb())
				.adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
				.email(entreprise.getEmail())
				.numTel(entreprise.getNumTel())
				.build();
	}
	
	public static Entreprise toEtity(EntrepriseDto entrepriseDto) {
		if (entrepriseDto == null) {
			return null;
		}
		
		Entreprise entreprise = new Entreprise();
		entreprise.setId(entrepriseDto.getId());
		entreprise.setNom(entrepriseDto.getNom());
		entreprise.setDescription(entrepriseDto.getDescription());
		entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
		entreprise.setPhoto(entrepriseDto.getPhoto());
		entreprise.setSteWeb(entrepriseDto.getSteWeb());
		entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));
		entreprise.setEmail(entrepriseDto.getEmail());
		entreprise.setNumTel(entrepriseDto.getEmail());
		
		return entreprise;
	}
}
