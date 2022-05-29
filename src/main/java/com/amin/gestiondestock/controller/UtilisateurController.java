package com.amin.gestiondestock.controller;

import com.amin.gestiondestock.controller.api.UtilisateurApi;
import com.amin.gestiondestock.dto.UtilisateurDto;
import com.amin.gestiondestock.services.UtilisateurService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurController implements UtilisateurApi {

    public UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) { this.utilisateurService = utilisateurService; }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return utilisateurService.save(dto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        utilisateurService.delete(id);
    }
}
