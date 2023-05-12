package br.com.fernando.games.domain.game;

public record DataDetailsGame(Long id, String name, String platform, String stars, Gender gender) {

	public DataDetailsGame(Game game) {
		this(game.getId(), game.getName(), game.getPlatform(), game.getStars(), game.getGender());
	}

}
