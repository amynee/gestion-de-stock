package com.amin.gestiondestock.controller.api;

import com.amin.gestiondestock.dto.MvtStkDto;
import com.amin.gestiondestock.dto.RolesDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.amin.gestiondestock.utils.Constants.APP_ROOT;

@Api("roles")
public interface RolesApi {

    @PostMapping(value = APP_ROOT + "/roles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    RolesDto save(@RequestBody MvtStkDto dto);

    @GetMapping(value = APP_ROOT + "/roles/{idRole}", produces = MediaType.APPLICATION_JSON_VALUE)
    RolesDto findById(@PathVariable("idRole") Integer id);

    @GetMapping(value = APP_ROOT + "/roles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<RolesDto> findAll();

    @GetMapping(value = APP_ROOT + "/roles/delete/{idRole}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idRole") Integer id);
}
