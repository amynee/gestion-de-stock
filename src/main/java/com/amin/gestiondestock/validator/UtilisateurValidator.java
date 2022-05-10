package com.amin.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amin.gestiondestock.dto.UtilisateurDto;

public class UtilisateurValidator {
	
	public static List<String> validate(UtilisateurDto utilisateurDto) {
		List<String> errors = new ArrayList<>();
		
		if (!StringUtils.hasLength(utilisateurDto.getNom())) {
			errors.add("Veuillez renseigner le nom de l'utilsateur");
		}
		
		if (!StringUtils.hasLength(utilisateurDto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom de l'utilsateur");
		}
		
		if (!StringUtils.hasLength(utilisateurDto.getMotDePasse())) {
			errors.add("Veuillez renseigner le mot de passe de l'utilsateur");
		}
		
		if (!StringUtils.hasLength(utilisateurDto.getNom())) {
			errors.add("Veuillez renseigner le nom de l'utilsateur");
		}
		
		return errors;
	}

}
