package com.amin.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amin.gestiondestock.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
