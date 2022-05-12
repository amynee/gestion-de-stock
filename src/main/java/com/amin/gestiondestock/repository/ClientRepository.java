package com.amin.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amin.gestiondestock.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
