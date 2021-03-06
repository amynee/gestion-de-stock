package com.amin.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import com.amin.gestiondestock.dto.VentesDto;
import org.springframework.util.StringUtils;


public class VentesValidator {
	
	public static List<String> validate(VentesDto ventesDto) {
		List<String> errors = new ArrayList<>();
		
		if(ventesDto == null) {
			errors.add("Veuillez renseigner la code de vente");
			errors.add("Veuillez renseigner la date de vente");
		}
		
		if(!StringUtils.hasLength(ventesDto.getCode())) {
			errors.add("Veuillez renseigner la code de vente");
		}
		
		if(ventesDto.getDateVente() == null) {
			errors.add("Veuillez renseigner la date de vente");
		}
		
		return errors;
	}

}
