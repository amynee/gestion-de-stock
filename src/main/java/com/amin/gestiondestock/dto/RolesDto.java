package com.amin.gestiondestock.dto;

import com.amin.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {
	
	private Integer id;

	private String roleName;
	
	private Utilisateur utilisateur;
}
