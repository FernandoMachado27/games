package br.com.fernando.games.domain.game;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DataRegistrationGame(
		@NotBlank(message = "Name is required")
		String name,
		@NotBlank(message = "Platform is required")
		String platform,
		@NotNull(message = "Number of stars is required")
		@Pattern(regexp = "\\d{5}", message = "Invalid format")
		Integer stars,
		@NotNull(message = "Gender is required")
		Gender gender) {

}
