package br.com.fernando.games.domain.game;

import jakarta.validation.constraints.NotNull;

public record DataUpdateGame(
		@NotNull
		Long id,
		String name,
		String platform,
		String stars,
		Gender gender) {

}
