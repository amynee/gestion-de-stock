package com.amin.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amin.gestiondestock.dto.RolesDto;

public class RolesValidator {
	
	public static List<String> validate(RolesDto rolesDto) {
		List<String> errors = new ArrayList<>();
		
		if(rolesDto == null) {
			errors.add("Veuillez renseigner la role d'utilisatuer");
			errors.add("Veuillez renseigner l'utilisatuer");
			
			return errors;
		}
		
		if(!StringUtils.hasLength(rolesDto.getRoleName())) {
			errors.add("Veuillez renseigner la role d'utilisatuer");
		}
		
		if(rolesDto.getUtilisateur() == null) {
			errors.add("Veuillez renseigner l'utilisatuer");
		}
		
		return errors;
	}

}
