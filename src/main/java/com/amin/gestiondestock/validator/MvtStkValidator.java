package com.amin.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import com.amin.gestiondestock.dto.MvtStkDto;

public class MvtStkValidator {

	public static List<String> validate(MvtStkDto mvtStkDto) {
		List<String> errors = new ArrayList<>();
		
		if(mvtStkDto == null) {
			errors.add("Veuillez renseigner l'article de mouvement de stock");
			errors.add("Veuillez renseigner la quantite de mouvement de stock");
			errors.add("Veuillez renseigner la date de mouvement de stock");
			errors.add("Veuillez renseigner la type de mouvement de stock");
			
			return errors;
		}
		
		if(mvtStkDto.getArticle() == null) {
			errors.add("Veuillez renseigner l'article de mouvement de stock");
		}
		
		if(mvtStkDto.getQuantite() == null) {
			errors.add("Veuillez renseigner la quantite de mouvement de stock");
		}
		
		if(mvtStkDto.getDateMvt() == null) {
			errors.add("Veuillez renseigner la date de mouvement de stock");
		}
		
		if(mvtStkDto.getTypeMvt() == null) {
			errors.add("Veuillez renseigner la type de mouvement de stock");
		}
		
		return errors;
	}
}
