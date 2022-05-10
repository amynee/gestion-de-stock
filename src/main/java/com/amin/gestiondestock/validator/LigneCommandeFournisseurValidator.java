package com.amin.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import com.amin.gestiondestock.dto.LigneCommandeFournisseurDto;

public class LigneCommandeFournisseurValidator {
	
	public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurClientDto) {
		List<String> errors = new ArrayList<>();
		
		if(ligneCommandeFournisseurClientDto == null) {
			errors.add("Veuillez renseigner l'article de ligne commande client");
			errors.add("Veuillez renseigner la quantite de ligne commande client");
			errors.add("Veuillez renseigner le prix unitaire de ligne commande client");
			
			return errors;
		}
		
		if(ligneCommandeFournisseurClientDto.getArticle() == null) {
			errors.add("Veuillez renseigner l'article de ligne commande client");
		}
		
		if(ligneCommandeFournisseurClientDto.getQuantite() == null) {
			errors.add("Veuillez renseigner la quantite de ligne commande client");
		}
		
		if(ligneCommandeFournisseurClientDto.getPrixUnitaire() == null) {
			errors.add("Veuillez renseigner le prix unitaire de ligne commande client");
		}
		
		
		return errors;
	}

}
