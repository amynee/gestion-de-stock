package com.amin.gestiondestock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="typeMvtStk")
public class TypeMvtStk extends AbstractEntity {

	@Column(name="typeMvtStk")
	private String typeMvtStk;
}
