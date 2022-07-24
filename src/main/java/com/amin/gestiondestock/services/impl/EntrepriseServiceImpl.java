package com.amin.gestiondestock.services.impl;

import com.amin.gestiondestock.dto.ArticleDto;
import com.amin.gestiondestock.dto.EntrepriseDto;
import com.amin.gestiondestock.dto.RolesDto;
import com.amin.gestiondestock.dto.UtilisateurDto;
import com.amin.gestiondestock.exception.EntityNotFoundException;
import com.amin.gestiondestock.exception.ErrorCodes;
import com.amin.gestiondestock.exception.InvalidEntityException;
import com.amin.gestiondestock.model.Entreprise;
import com.amin.gestiondestock.repository.EntrepriseRepository;
import com.amin.gestiondestock.repository.RolesRepository;
import com.amin.gestiondestock.services.EntrepriseService;
import com.amin.gestiondestock.services.UtilisateurService;
import com.amin.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;
    private RolesRepository rolesRepository;
    private UtilisateurService utilisateurService;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository, RolesRepository rolesRepository, UtilisateurService utilisateurService) { 
    	this.entrepriseRepository = entrepriseRepository; 
    	this.rolesRepository = rolesRepository;
    	this.utilisateurService = utilisateurService;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
        }

        EntrepriseDto savedEntreprise = EntrepriseDto.fromEntity(
                entrepriseRepository.save(
                        EntrepriseDto.toEntity(dto)
                )
        );
        
        UtilisateurDto utilisateur = fromEntreprise(savedEntreprise);
        
        UtilisateurDto savedUser = utilisateurService.save(utilisateur);
        
        RolesDto rolesDto = RolesDto.builder()
        		.roleName("ADMIN")
        		.utilisateur(savedUser)
        		.build();
        		
        rolesRepository.save(RolesDto.toEntity(rolesDto));
        
        return savedEntreprise;
    }
    
    private UtilisateurDto fromEntreprise(EntrepriseDto dto) {
    	return UtilisateurDto.builder()
    			.adresse(dto.getAdresse())
    			.nom(dto.getNom())
    			.prenom(dto.getCodeFiscal())
    			.email(dto.getEmail())
    			.motDePasse("123546")
    			.entreprise(dto)
    			.dateDeNaissance(Instant.now())
    			.photo(dto.getPhoto())
    			.build();
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
