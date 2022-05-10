package com.amin.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amin.gestiondestock.dto.LigneVenteDto;

public class LigneVenteValidator {

	public static List<String> validate(LigneVenteDto ligneVenteDto) {
		List<String> errors = new ArrayList<>();
		
		if (ligneVenteDto == null) {
			errors.add("Veuillez renseigner la vnete de ligne vente");
			errors.add("Veuillez renseigner la quantite de ligne vente");
			errors.add("Veuillez renseigner la prix unitaire de ligne vente");
			
			return errors;
		}
		
		if(ligneVenteDto.getVente() == null) {
			errors.add("Veuillez renseigner la vnete de ligne vente");
		}
		
		if(ligneVenteDto.getQuantite() == null) {
			errors.add("Veuillez renseigner la quantite de ligne vente");
		}
		
		if(ligneVenteDto.getPrixUnitaire() == null) {
			errors.add("Veuillez renseigner la prix unitaire de ligne vente");
		}
		
		return errors;
	}
}
