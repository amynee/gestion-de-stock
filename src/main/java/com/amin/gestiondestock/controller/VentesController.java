package com.amin.gestiondestock.controller;

import com.amin.gestiondestock.controller.api.VentesApi;
import com.amin.gestiondestock.dto.CommandeFournisseurDto;
import com.amin.gestiondestock.dto.VentesDto;
import com.amin.gestiondestock.services.VentesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VentesController implements VentesApi {

    VentesService ventesService;

    @Autowired
    public VentesController(VentesService ventesService) { this.ventesService = ventesService; }

    @Override
    public VentesDto save(VentesDto dto) {
        return ventesService.save(dto);
    }

    @Override
    public VentesDto findById(Integer id) {
        return ventesService.findById(id);
    }

    @Override
    public VentesDto findVentesByCode(String code) {
        return ventesService.findByCode(code);
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesService.findAll();
    }

    @Override
    public void delete(Integer id) {
        ventesService.delete(id);
    }
}
