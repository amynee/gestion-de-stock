package com.amin.gestiondestock.services.auth;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amin.gestiondestock.exception.EntityNotFoundException;
import com.amin.gestiondestock.exception.ErrorCodes;
import com.amin.gestiondestock.model.Utilisateur;
import com.amin.gestiondestock.repository.UtilisateurRepository;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UtilisateurRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		//Utilisateur utilisateur = repository.findUtilisateurByEmail(email).orElseThrow(() -> 
			//new EntityNotFoundException("Aucun utilisateur avec l'email fourni", ErrorCodes.UTILISATEUR_NOT_FOUND)
		//);
		
		//return new User(utilisateur.getEmail(), utilisateur.getMotDePasse(), Collections.emptyList());
		return new User("amine", "amine", Collections.emptyList());
	}

}
