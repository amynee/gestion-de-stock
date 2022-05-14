package com.amin.gestiondestock.services.impl;

import com.amin.gestiondestock.dto.ArticleDto;
import com.amin.gestiondestock.dto.EntrepriseDto;
import com.amin.gestiondestock.exception.EntityNotFoundException;
import com.amin.gestiondestock.exception.ErrorCodes;
import com.amin.gestiondestock.exception.InvalidEntityException;
import com.amin.gestiondestock.model.Entreprise;
import com.amin.gestiondestock.repository.EntrepriseRepository;
import com.amin.gestiondestock.services.EntrepriseService;
import com.amin.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) { this.entrepriseRepository = entrepriseRepository; }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
        }

        return EntrepriseDto.fromEntity(
                entrepriseRepository.save(
                        EntrepriseDto.toEtity(dto)
                )
        );
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }

        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() ->
            new EntityNotFoundException(
                    "Aucun entreprise avec l'ID = " + id + " n'été trouvé dans la BDD",
                    ErrorCodes.ENTREPRISE_NOT_FOUND
            )
        );
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Entreprise ID is null");
            return;
        }

        entrepriseRepository.deleteById(id);
    }
}
