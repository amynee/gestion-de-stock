package com.amin.gestiondestock.controller.api;

import com.amin.gestiondestock.dto.LigneCommandeClientDto;
import com.amin.gestiondestock.dto.LigneCommandeFournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.amin.gestiondestock.utils.Constants.APP_ROOT;

@Api("lignes-commande-fournisseur")
public interface LigneCommandeFournisseurApi {

    @PostMapping(value = APP_ROOT + "/lignes-commande-fournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    LigneCommandeFournisseurDto save(@RequestBody LigneCommandeFournisseurDto dto);

    @GetMapping(value = APP_ROOT + "/lignes-commande-fournisseur/{idligneComandeFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    LigneCommandeFournisseurDto findById(@PathVariable("idligneComandeFournisseur") Integer id);

    @GetMapping(value = APP_ROOT + "/lignes-commande-fournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneCommandeFournisseurDto> findAll();

    @GetMapping(value = APP_ROOT + "/lignes-commande-fournisseur/delete/{idligneComandeFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idligneComandeFournisseur") Integer id);
}
