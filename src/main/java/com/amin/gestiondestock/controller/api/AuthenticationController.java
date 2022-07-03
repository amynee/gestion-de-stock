package com.amin.gestiondestock.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amin.gestiondestock.dto.auth.AuthenticationRequest;
import com.amin.gestiondestock.dto.auth.AuthenticationResponse;
import com.amin.gestiondestock.services.auth.ApplicationUserDetailsService;
import com.amin.gestiondestock.utils.JwtUtil;

import static com.amin.gestiondestock.utils.Constants.AUTHENTICATION_ENDPOINT;

@RestController
@RequestMapping(AUTHENTICATION_ENDPOINT)
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ApplicationUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getLogin(),
						request.getPassword()
				)
		);
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
		
	}

}
