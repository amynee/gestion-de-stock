package com.amin.gestiondestock.dto;

import java.util.List;

import com.amin.gestiondestock.model.Fournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FournisseurDto {
	
	private Integer id;
	
	private String nom;
	
	private String prenom;
	
	private AdresseDto adresse;
	
	private String photo;
	
	private String email;
	
	private String numTel;
	
	private List<CommandeFournisseurDto> commandeFournisseurs;
	
	public static FournisseurDto fromEntity(Fournisseur fournisseur) {
		if (fournisseur == null) {
			return null;
		}
		
		return FournisseurDto.builder()
				.id(fournisseur.getId())
				.nom(fournisseur.getNom())
				.prenom(fournisseur.getPrenom())
				.numTel(fournisseur.getNumTel())
				.photo(fournisseur.getPhoto())
				.email(fournisseur.getEmail())
				.adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
				.build();
	}
	
	public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
		if (fournisseurDto == null) {
			return null;
		}
		
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setId(fournisseurDto.getId());
		fournisseur.setNom(fournisseurDto.getNom());
		fournisseur.setPrenom(fournisseurDto.getPrenom());
		fournisseur.setNumTel(fournisseurDto.getNumTel());
		fournisseur.setPhoto(fournisseurDto.getPhoto());
		fournisseur.setEmail(fournisseurDto.getEmail());
		fournisseur.setAdresse(AdresseDto.toEntity(fournisseurDto.getAdresse()));
		
		return fournisseur;
	}
}
