package com.amin.gestiondestock.controller.api;

import com.amin.gestiondestock.dto.CommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.amin.gestiondestock.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/commandes-client")
public interface CommandeClientApi {

    @PostMapping(value = APP_ROOT + "/commandes-client/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto save(@RequestBody CommandeClientDto dto);

    @GetMapping(value = APP_ROOT + "/commandes-client/{idComandeClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto findById(@PathVariable("idCommandeClient") Integer id);

    @GetMapping(value = APP_ROOT + "/commandes-client/{codeCommandeClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto findCommandeClientByCode(@PathVariable("codeCommandeClient") String code);

    @GetMapping(value = APP_ROOT + "/commandes-client/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CommandeClientDto> findAll();

    @GetMapping(value = APP_ROOT + "/commandse-client/delete/{idComandeClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idCommandeClient") Integer id);
}
