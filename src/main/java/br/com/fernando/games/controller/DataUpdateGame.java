package br.com.fernando.games.controller;

import br.com.fernando.games.domain.game.Gender;
import jakarta.validation.constraints.NotNull;

public record DataUpdateGame(
		@NotNull
		Long id,
		String name,
		String platform,
		String stars,
		Gender gender) {

}
