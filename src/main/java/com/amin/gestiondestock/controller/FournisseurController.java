package com.amin.gestiondestock.controller;

import com.amin.gestiondestock.controller.api.FournisseurApi;
import com.amin.gestiondestock.dto.CategoryDto;
import com.amin.gestiondestock.dto.FournisseurDto;
import com.amin.gestiondestock.services.FournisseurService;

import java.util.List;

public class FournisseurController implements FournisseurApi {

    private FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) { this.fournisseurService = fournisseurService; }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        return fournisseurService.save(dto);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return fournisseurService.findById(id);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        fournisseurService.delete(id);
    }
}
