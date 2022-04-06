package com.amin.gestiondestock.dto;

import java.util.List;
import com.amin.gestiondestock.model.Adresse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
	
	private Integer id;

	private String nom;
	
	private String prenom;
	
	private Adresse adresse;
	
	private String photo;
	
	private String mail;
	
	private String numTel;
	
	private List<CommandeClientDto> commandesClient;

}
