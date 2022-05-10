package com.amin.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amin.gestiondestock.dto.CommandeClientDto;

public class CommandeClientValidator {

	public static List<String> validate(CommandeClientDto commandeClientDto) {
		List<String> errors = new ArrayList<>();
		
		if (commandeClientDto == null || !StringUtils.hasLength(commandeClientDto.getCode())) {
			errors.add("Veuillez renseigner le code de la category");
		}
		
		return errors;
	}
}
