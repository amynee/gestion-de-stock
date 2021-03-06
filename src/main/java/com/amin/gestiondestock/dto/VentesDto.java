package com.amin.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import com.amin.gestiondestock.model.Article;
import com.amin.gestiondestock.model.Ventes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VentesDto {
	
	private Integer id;
	
	private String code;
	
	private Instant dateVente;
	
	private String commentaire;

	private List<LigneVenteDto> ligneVentes;
	
	public static VentesDto fromEntity(Ventes ventes) {
		if (ventes == null) {
			return null;
		}
		
		return VentesDto.builder()
				.id(ventes.getId())
				.code(ventes.getCode())
				.dateVente(ventes.getDateVente())
				.commentaire(ventes.getCommentaire())
				.build();
	}
	
	public static Ventes toEtity(VentesDto ventesDto) {
		if (ventesDto == null) {
			return null;
		}
		
		Ventes ventes = new Ventes();
		ventes.setId(ventesDto.getId());
		ventes.setCode(ventesDto.getCode());
		ventes.setDateVente(ventes.getDateVente());
		ventes.setCommentaire(ventesDto.getCommentaire());
		
		return ventes;
	}
}
