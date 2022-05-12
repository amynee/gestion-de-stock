package com.amin.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amin.gestiondestock.model.LigneCommandeClient;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {

}
