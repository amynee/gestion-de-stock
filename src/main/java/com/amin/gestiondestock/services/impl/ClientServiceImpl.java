package com.amin.gestiondestock.services.impl;

import com.amin.gestiondestock.dto.ClientDto;
import com.amin.gestiondestock.exception.EntityNotFoundException;
import com.amin.gestiondestock.exception.ErrorCodes;
import com.amin.gestiondestock.exception.InvalidEntityException;
import com.amin.gestiondestock.model.Client;
import com.amin.gestiondestock.repository.ClientRepository;
import com.amin.gestiondestock.services.ClientService;
import com.amin.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) { this.clientRepository = clientRepository; }


    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.Client_NOT_VALID, errors);
        }

        return ClientDto.fromEntity(
                clientRepository.save(
                        ClientDto.toEntity(dto)
                )
        );
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return  null;
        }

        Optional<Client> client = clientRepository.findById(id);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() ->
                 new EntityNotFoundException(
                         "Aucun client avec l'ID = " + id + " n'été trouvé dans la BDD",
                         ErrorCodes.Client_NOT_FOUND
                 )
        );
    }

    @Override
    public List<ClientDto> findAll() {
       return clientRepository.findAll().stream()
               .map(ClientDto::fromEntity)
               .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return;
        }

        clientRepository.deleteById(id);
    }
}
