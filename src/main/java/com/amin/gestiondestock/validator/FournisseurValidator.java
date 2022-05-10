package com.amin.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amin.gestiondestock.dto.FournisseurDto;

public class FournisseurValidator {

	public static List<String> validate(FournisseurDto fournissuerDto) {
		List<String> errors = new ArrayList();
		
		if (fournissuerDto == null) {
			errors.add("Veuillez renseigner le nom du client");
			errors.add("Veuillez renseigner le prenom du client");
			errors.add("Veuillez renseigner l'email du client");
			errors.add("Veuillez renseigner le numero de telephone du client");
			
			return errors;
		}
		
		if(!StringUtils.hasLength(fournissuerDto.getNom())) {
			errors.add("Veuillez renseigner le nom du fournissuer");
		}
		
		if(!StringUtils.hasLength(fournissuerDto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom du fournissuer");
		}
		
		if(!StringUtils.hasLength(fournissuerDto.getEmail())) {
			errors.add("Veuillez renseigner l'email du fournissuer");
		}
		
		if(!StringUtils.hasLength(fournissuerDto.getNumTel())) {
			errors.add("Veuillez renseigner le numero de telephone du fournissuer");
		}
		
		return errors;
	}
}
