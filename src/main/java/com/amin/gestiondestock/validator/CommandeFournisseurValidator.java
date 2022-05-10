package com.amin.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amin.gestiondestock.dto.CommandeFournisseurDto;

public class CommandeFournisseurValidator {

	public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto) {
		List<String> errors = new ArrayList<>();
		
		if (commandeFournisseurDto == null || !StringUtils.hasLength(commandeFournisseurDto.getCode())) {
			errors.add("Veuillez renseigner le code de la category");
		}
		
		return errors;
	}
}
