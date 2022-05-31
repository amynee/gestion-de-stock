package com.amin.gestiondestock.controller.api;

import com.amin.gestiondestock.dto.CommandeFournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.amin.gestiondestock.utils.Constants.*;

@Api(COMMANDE_FOURNISSEUR_ENDPOINT)
public interface CommandeFournisseurApi {

    @PostMapping(value = CREATE_COMMANDE_FOURNISSEUR_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto);

    @GetMapping(value = FIND_COMMANDE_FOURNISSEUR_BY_ID_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto findById(@PathVariable("idCommandeFournisseur") Integer id);

    @GetMapping(value = FIND_COMMANDE_FOURNISSEUR_BY_CODE_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto findCommandeFournisseurByCode(@PathVariable("codeCommandeFournisseur") String code);

    @GetMapping(value = FIND_ALL_COMMANDE_FOURNISSEUR_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CommandeFournisseurDto> findAll();

    @DeleteMapping(value = DELETE_COMMANDE_FOURNISSEUR_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idCommandeFournisseur") Integer id);
}
