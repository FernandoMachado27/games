package br.com.fernando.games.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.games.domain.user.DataAuthentication;
import br.com.fernando.games.domain.user.User;
import br.com.fernando.games.infra.security.DataTokenJWT;
import br.com.fernando.games.infra.security.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity login(@RequestBody @Valid DataAuthentication dataAuthentication) {
		try {
		var authenticationToken = new UsernamePasswordAuthenticationToken(dataAuthentication.username(), dataAuthentication.password());
		var authentication = manager.authenticate(authenticationToken);
		
		var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
		
		return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
