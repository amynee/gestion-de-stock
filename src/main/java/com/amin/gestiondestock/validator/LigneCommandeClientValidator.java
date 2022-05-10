package com.amin.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import com.amin.gestiondestock.dto.LigneCommandeClientDto;

public class LigneCommandeClientValidator {

	public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto) {
		List<String> errors = new ArrayList<>();
		
		if(ligneCommandeClientDto == null) {
			errors.add("Veuillez renseigner l'article de ligne commande client");
			errors.add("Veuillez renseigner la quantite de ligne commande client");
			errors.add("Veuillez renseigner le prix unitaire de ligne commande client");
		}
		
		if(ligneCommandeClientDto.getArticle() == null) {
			errors.add("Veuillez renseigner l'article de ligne commande client");
		}
		
		if(ligneCommandeClientDto.getQuantite() == null) {
			errors.add("Veuillez renseigner la quantite de ligne commande client");
		}
		
		if(ligneCommandeClientDto.getPrixUnitaire() == null) {
			errors.add("Veuillez renseigner le prix unitaire de ligne commande client");
		}
		
		
		return errors;
	}
}
