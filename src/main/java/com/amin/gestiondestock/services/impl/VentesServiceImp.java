package com.amin.gestiondestock.services.impl;

import com.amin.gestiondestock.dto.CommandeFournisseurDto;
import com.amin.gestiondestock.dto.LigneVenteDto;
import com.amin.gestiondestock.dto.VentesDto;
import com.amin.gestiondestock.exception.EntityNotFoundException;
import com.amin.gestiondestock.exception.ErrorCodes;
import com.amin.gestiondestock.exception.InvalidEntityException;
import com.amin.gestiondestock.model.Article;
import com.amin.gestiondestock.model.LigneVente;
import com.amin.gestiondestock.model.Ventes;
import com.amin.gestiondestock.repository.ArticleRepository;
import com.amin.gestiondestock.repository.LigneVenteRepository;
import com.amin.gestiondestock.repository.VentesRepository;
import com.amin.gestiondestock.services.VentesService;
import com.amin.gestiondestock.validator.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VentesServiceImp implements VentesService {

    private ArticleRepository articleRepository;
    private VentesRepository ventesRepository;
    private LigneVenteRepository ligneVenteRepository;

    @Autowired
    public VentesServiceImp(ArticleRepository articleRepository, VentesRepository ventesRepository, LigneVenteRepository ligneVenteRepository) {
        this.articleRepository = articleRepository;
        this.ventesRepository = ventesRepository;
        this.ligneVenteRepository = ligneVenteRepository;
    }


    @Override
    public VentesDto save(VentesDto dto) {
        List<String> errors = VentesValidator.validate(dto);

        if(!errors.isEmpty()) {
            log.error("Ventes n'est pas valide");
            throw new InvalidEntityException("L'objet vente n'est pas valide", ErrorCodes.VENTE_NOT_VALID);
        }

        List<String> articleErrors = new ArrayList<>();

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
            if (article.isEmpty()) {
                articleErrors.add("Aucun article avec l'ID " + ligneVenteDto.getArticle().getId() + "n'a été trouvé dans la BDD");
            }
        });

        if (!articleErrors.isEmpty()) {
            log.error("One or more article were not found in the DB, {}", errors);
            throw new InvalidEntityException("un ou plusieurs articles n'ont été trouvé dans le BDD", ErrorCodes.VENTE_NOT_VALID, errors);
        }

        Ventes saveVente = ventesRepository.save(VentesDto.toEtity(dto));

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            LigneVente ligneVente = LigneVenteDto.toEtity(ligneVenteDto);
            ligneVente.setVente(saveVente);
            ligneVenteRepository.save(ligneVente);
        });

        return VentesDto.fromEntity(saveVente);
    }

    @Override
    public VentesDto findById(Integer id) {
        if (id == null) {
            log.error("Vente ID is NULL");
            return null;
        }

        return ventesRepository.findById(id)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune ventes n'a été trouvé avec l'ID " + id, ErrorCodes.VENTE_NOT_FOUND
                ));
    }

    @Override
    public VentesDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente CODE is NULL");
            return null;
        }

        return ventesRepository.findVentesByCode(code)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune vente n'a été trouvé avec le CODE " + code, ErrorCodes.VENTE_NOT_VALID
                ));
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream()
                .map(VentesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Vente ID is NULL");
            return;
        }

        ventesRepository.deleteById(id);
    }
}
