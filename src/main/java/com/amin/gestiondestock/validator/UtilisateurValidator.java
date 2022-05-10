package com.amin.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amin.gestiondestock.dto.UtilisateurDto;

public class UtilisateurValidator {
	
	public static List<String> validate(UtilisateurDto utilisateurDto) {
		List<String> errors = new ArrayList<>();
		
		if (utilisateurDto == null) {
			errors.add("Veuillez renseigner le nom d'utilsateur");
			errors.add("Veuillez renseigner le prenom d'utilsateur");
			errors.add("Veuillez renseigner l'email d'utilsateur");
			errors.add("Veuillez renseigner le mot de passe d'utilsateur");
			errors.add("Veuillez renseigner l'adresse d'utilsateur");
			
			return errors;
		}
		
		if (!StringUtils.hasLength(utilisateurDto.getNom())) {
			errors.add("Veuillez renseigner le nom d'utilsateur");
		}
		
		if (!StringUtils.hasLength(utilisateurDto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom d'utilsateur");
		}
		
		if (!StringUtils.hasLength(utilisateurDto.getEmail())) {
			errors.add("Veuillez renseigner l'email d'utilsateur");
		}
		
		if (!StringUtils.hasLength(utilisateurDto.getMotDePasse())) {
			errors.add("Veuillez renseigner le mot de passe d'utilsateur");
		}
		
		if (utilisateurDto.getDateDeNaissance() == null) {
			errors.add("Veuillez renseigner la date de naissance d'utilsateur");
		}
		
		if (utilisateurDto.getAdresse() == null) {
			errors.add("Veuillez renseigner l'adresse d'utilsateur");
		} else {
			if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())) {
				errors.add("Le champs 'Adresse 1' est obligatoire");
			}
			
			if (!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())) {
				errors.add("Le champs 'Ville' est obligatoire");
			}
			
			if (!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())) {
				errors.add("Le champs 'Code Postale' est obligatoire");
			}
			
			if (!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())) {
				errors.add("Le champs 'Pays' est obligatoire");
			}
		}
		
		return errors;
	}

}
