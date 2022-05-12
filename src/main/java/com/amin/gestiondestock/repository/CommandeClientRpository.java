package com.amin.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amin.gestiondestock.model.CommandeClient;

public interface CommandeClientRpository extends JpaRepository<CommandeClient, Integer> {

}
