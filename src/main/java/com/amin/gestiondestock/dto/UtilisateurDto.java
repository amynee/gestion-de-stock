package com.amin.gestiondestock.dto;

import java.util.List;
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
}
