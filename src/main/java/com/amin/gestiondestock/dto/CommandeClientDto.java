package com.amin.gestiondestock.dto;

import java.time.Instant;
import java.util.List;
import com.amin.gestiondestock.model.Client;
import com.amin.gestiondestock.model.CommandeClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeClientDto {
	
	private Integer id;

	private String code;

	private Instant dateCommande;
	
	private Client client;
	
	private List<LigneCommandeClientDto> ligneCommandesClient;
	
	public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
		if (commandeClient == null) {
			return null;
		}
		
		return CommandeClientDto.builder()
				.id(commandeClient.getId())
				.code(commandeClient.getCode())
				.dateCommande(commandeClient.getDateCommande())
				.client(commandeClient.getClient())
				.build();
	}
	
	public static CommandeClient toEtity(CommandeClientDto commandeClientDto) {
		if (commandeClientDto == null) {
			return null;
		}
		
		CommandeClient commandeClient = new CommandeClient();
		commandeClient.setId(commandeClientDto.getId());
		commandeClient.setCode(commandeClientDto.getCode());
		commandeClient.setDateCommande(commandeClientDto.getDateCommande());
		commandeClient.setClient(commandeClientDto.getClient());
		
		return commandeClient;
	}
}
