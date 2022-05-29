package com.amin.gestiondestock.controller.api;

import com.amin.gestiondestock.dto.LigneCommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.amin.gestiondestock.utils.Constants.APP_ROOT;

@Api("lignes-commande-client")
public interface LigneCommandeClientApi {

    @PostMapping(value = APP_ROOT + "/lignes-commande-client/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    LigneCommandeClientDto save(@RequestBody LigneCommandeClientDto dto);

    @GetMapping(value = APP_ROOT + "/lignes-commande-client/{idligneComandeClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    LigneCommandeClientDto findById(@PathVariable("idligneComandeClient") Integer id);

    @GetMapping(value = APP_ROOT + "/lignes-commande-client/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneCommandeClientDto> findAll();

    @GetMapping(value = APP_ROOT + "/lignes-commande-client/delete/{idligneComandeClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idligneComandeClient") Integer id);

}
