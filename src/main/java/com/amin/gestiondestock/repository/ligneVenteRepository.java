package com.amin.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amin.gestiondestock.model.LigneVente;

public interface ligneVenteRepository extends JpaRepository<LigneVente, Integer> {

}