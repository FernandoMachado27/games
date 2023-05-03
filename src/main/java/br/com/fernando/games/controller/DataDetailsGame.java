package br.com.fernando.games.controller;

import br.com.fernando.games.domain.game.Game;
import br.com.fernando.games.domain.game.Gender;

public record DataDetailsGame(Long id, String name, String platform, Integer stars, Gender gender) {

	public DataDetailsGame(Game game) {
		this(game.getId(), game.getName(), game.getPlatform(), game.getStars(), game.getGender());
	}

}
