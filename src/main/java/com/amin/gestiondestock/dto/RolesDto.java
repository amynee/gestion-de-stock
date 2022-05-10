package com.amin.gestiondestock.dto;

import com.amin.gestiondestock.model.Roles;
import com.amin.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {
	
	private Integer id;

	private String roleName;
	
	private Utilisateur utilisateur;
	
	public static RolesDto fromEntity(Roles roles) {
		if (roles == null) {
			return null;
		}
		
		return RolesDto.builder()
				.id(roles.getId())
				.roleName(roles.getRoleName())
				.utilisateur(roles.getUtilisateur())
				.build();
	}
	
	public static Roles toEtity(RolesDto rolesDto) {
		if (rolesDto == null) {
			return null;
		}
		
		Roles roles = new Roles();
		roles.setId(rolesDto.getId());
		roles.setRoleName(rolesDto.getRoleName());
		roles.setUtilisateur(rolesDto.getUtilisateur());
		
		return roles;
	}
}
