package com.amin.gestiondestock.controller.api;

import com.amin.gestiondestock.dto.MvtStkDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.amin.gestiondestock.utils.Constants.APP_ROOT;

@Api("/mouvements-stock")
public interface MvtStkApi {

    @PostMapping(value = APP_ROOT + "/mouvements-stock/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    MvtStkDto save(@RequestBody MvtStkDto dto);

    @GetMapping(value = APP_ROOT + "/mouvements-stock/{idMvtStk}", produces = MediaType.APPLICATION_JSON_VALUE)
    MvtStkDto findById(@PathVariable("idMvtStk") Integer id);

    @GetMapping(value = APP_ROOT + "/mouvements-stock/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MvtStkDto> findAll();

    @GetMapping(value = APP_ROOT + "/mouvements-stock/delete/{idMvtStk}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idMvtStk") Integer id);

}
