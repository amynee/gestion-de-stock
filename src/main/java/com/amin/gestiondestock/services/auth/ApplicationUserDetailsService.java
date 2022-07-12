package com.amin.gestiondestock.services.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amin.gestiondestock.dto.UtilisateurDto;
import com.amin.gestiondestock.model.auth.ExtendedUser;
import com.amin.gestiondestock.services.UtilisateurService;
import com.amin.gestiondestock.services.impl.UtilisateurServiceImpl;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UtilisateurService service;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UtilisateurDto utilisateur = service.findByEmail(email);
		System.out.println(utilisateur);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//		utilisateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
		return new ExtendedUser(utilisateur.getEmail(), utilisateur.getMotDePasse(), utilisateur.getEntreprise().getId(),  authorities);
	}

}
