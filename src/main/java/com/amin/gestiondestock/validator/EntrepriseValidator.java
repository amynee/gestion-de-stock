package com.amin.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amin.gestiondestock.dto.EntrepriseDto;

public class EntrepriseValidator {

	public static List<String> validate(EntrepriseDto entrepriseDto) {
		List<String> errors = new ArrayList<>();
		
		if(entrepriseDto == null) {
			errors.add("Veuillez renseigner le nom d'entreprise");
			errors.add("Veuillez renseigner le code fiscale d'entreprise");
			errors.add("Veuillez renseigner le code fiscale d'entreprise");
		}
		
		if (!StringUtils.hasLength(entrepriseDto.getNom())) {
			errors.add("Veuillez renseigner le nom d'entreprise");
		}
		
		if (!StringUtils.hasLength(entrepriseDto.getCodeFiscal())) {
			errors.add("Veuillez renseigner le code fiscale d'entreprise");
		}
		
		if (!StringUtils.hasLength(entrepriseDto.getCodeFiscal())) {
			errors.add("Veuillez renseigner le code fiscale d'entreprise");
		}
		
		if (entrepriseDto.getAdresse() == null) {
			errors.add("Veuillez renseigner l'adresse d'utilsateur");
		} else {
			if (!StringUtils.hasLength(entrepriseDto.getAdresse().getAdresse1())) {
				errors.add("Le champs 'Adresse 1' est obligatoire");
			}
			
			if (!StringUtils.hasLength(entrepriseDto.getAdresse().getVille())) {
				errors.add("Le champs 'Ville' est obligatoire");
			}
			
			if (!StringUtils.hasLength(entrepriseDto.getAdresse().getCodePostale())) {
				errors.add("Le champs 'Code Postale' est obligatoire");
			}
			
			if (!StringUtils.hasLength(entrepriseDto.getAdresse().getPays())) {
				errors.add("Le champs 'Pays' est obligatoire");
			}
		}
		
		return errors;
	}
}
