package com.amin.gestiondestock.dto;

import java.util.List;

import com.amin.gestiondestock.model.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurDto {
	
	private Integer id;
	
	private String nom;
	
	private String dateDeNaissance;
	
	private String motDePasse;
	
	private String prenom;
	
	private AdresseDto adresse;
	
	private String photo;
	
	private String email;
	
	private EntrepriseDto entreprise;
	
	private List<RolesDto> roles;
	
	public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
		if (utilisateur == null) {
			return null;
		}
		
		return UtilisateurDto.builder()
				.id(utilisateur.getId())
				.nom(utilisateur.getNom())
				.prenom(utilisateur.getPrenom())
				.email(utilisateur.getEmail())
				.motDePasse(utilisateur.getMotDePasse())
				.dateDeNaissance(utilisateur.getDateDeNaissance())
				.adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
				.photo(utilisateur.getPhoto())
				.entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
				.build();
	}
	
	public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {
		if (utilisateurDto == null) {
			return null;
		}
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(utilisateurDto.getId());
		utilisateur.setNom(utilisateurDto.getNom());
		utilisateur.setPrenom(utilisateurDto.getPrenom());
		utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
		utilisateur.setEmail(utilisateurDto.getEmail());
		utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
		utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));
		utilisateur.setPhoto(utilisateurDto.getPhoto());
		
		return utilisateur;
	}
}
