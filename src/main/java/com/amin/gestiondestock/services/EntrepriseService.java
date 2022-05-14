package com.amin.gestiondestock.services;

import com.amin.gestiondestock.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto dto);
    EntrepriseDto findById(Integer id);
    List<EntrepriseDto> findAll();
    void delete(Integer id);
}
