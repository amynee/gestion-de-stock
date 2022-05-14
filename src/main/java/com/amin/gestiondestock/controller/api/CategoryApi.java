package com.amin.gestiondestock.controller.api;

import com.amin.gestiondestock.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.amin.gestiondestock.utils.Constants.APP_ROOT;

public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/category/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(value = APP_ROOT + "/category/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("idCategory") Integer id);

    @GetMapping(value = APP_ROOT + "/category/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCodeCategory(@PathVariable("codeCategory") String code);

    @GetMapping(value = APP_ROOT + "/article/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @GetMapping(value = APP_ROOT + "article/delete/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idCategory") Integer id);
}
