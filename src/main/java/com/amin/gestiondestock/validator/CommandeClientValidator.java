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

		if (commandeClientDto.getClient() == null) {
			errors.add("Pas de client pour cette commande");
		} else {
			if (commandeClientDto.getClient().getId() == null) {
				errors.add("Veuillez confirmer une client pour cette commande");
			}
		}
		
		return errors;
	}
}
