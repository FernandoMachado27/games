package br.com.fernando.games.domain.user;

import jakarta.validation.constraints.NotBlank;

public record DataAuthentication(
		@NotBlank
		String username, 
		@NotBlank
		String password) {

}
