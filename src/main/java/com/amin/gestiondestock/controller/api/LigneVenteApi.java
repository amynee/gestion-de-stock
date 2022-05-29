package com.amin.gestiondestock.controller.api;

import com.amin.gestiondestock.dto.LigneVenteDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.amin.gestiondestock.utils.Constants.APP_ROOT;

@Api("/lignes-ventes")
public interface LigneVenteApi {

    @PostMapping(value = APP_ROOT + "/lignes-ventes/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    LigneVenteDto save(@RequestBody LigneVenteDto dto);

    @GetMapping(value = APP_ROOT + "/lignes-ventes/{idLigneVente}", produces = MediaType.APPLICATION_JSON_VALUE)
    LigneVenteDto findById(@PathVariable("idLigneVente") Integer id);

    @GetMapping(value = APP_ROOT + "/lignes-ventes/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneVenteDto> findAll();

    @GetMapping(value = APP_ROOT + "/lignes-ventes/delete/{idLigneVente}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idLigneVente") Integer id);

}
