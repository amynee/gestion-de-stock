package com.amin.gestiondestock.controller.api;

import com.amin.gestiondestock.dto.CommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.amin.gestiondestock.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/commandes-clients")
public interface CommandeClientApi {

    @PostMapping(value = APP_ROOT + "/commandes-clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);

    @GetMapping(value = APP_ROOT + "/commandes-clients/{idComandeClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeClientDto> findById(@PathVariable("idCommandeClient") Integer id);

    @GetMapping(value = APP_ROOT + "/commandes-clients/{codeCommandeClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeClientDto> findCommandeClientByCode(@PathVariable("codeCommandeClient") String code);

    @GetMapping(value = APP_ROOT + "/commandes-clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CommandeClientDto>> findAll();

    @DeleteMapping(value = APP_ROOT + "/commandse-clients/delete/{idComandeClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity delete(@PathVariable("idCommandeClient") Integer id);
}
