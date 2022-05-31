package com.amin.gestiondestock.controller.api;

import com.amin.gestiondestock.dto.CommandeFournisseurDto;
import com.amin.gestiondestock.dto.VentesDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.amin.gestiondestock.utils.Constants.APP_ROOT;
import static com.amin.gestiondestock.utils.Constants.VENTES_ENDPOINT;

@Api(VENTES_ENDPOINT)
public interface VentesApi {

    @PostMapping(value = VENTES_ENDPOINT + "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    VentesDto save(@RequestBody VentesDto dto);

    @GetMapping(value = VENTES_ENDPOINT + "/{idVente}", produces = MediaType.APPLICATION_JSON_VALUE)
    VentesDto findById(@PathVariable("idVente") Integer id);

    @GetMapping(value = VENTES_ENDPOINT + "/{codeVente}", produces = MediaType.APPLICATION_JSON_VALUE)
    VentesDto findVentesByCode(@PathVariable("codeVente") String code);

    @GetMapping(value = VENTES_ENDPOINT + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<VentesDto> findAll();

    @DeleteMapping(value = VENTES_ENDPOINT + "/delete/{idVente}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idVente") Integer id);

}
