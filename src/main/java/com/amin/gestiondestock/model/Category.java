package com.amin.gestiondestock.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="category")
public class Category extends AbstractEntity {
	
	@Column(name="code")
	private String code;
	
	@Column(name="desgination")
	private String designation;
	
	@OneToMany(mappedBy="category")
	private List<Article> articles;
	
	@Column(name="identreprise")
	private Integer idEntreprise;
}
