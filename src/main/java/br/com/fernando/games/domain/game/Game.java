package br.com.fernando.games.domain.game;

import br.com.fernando.games.controller.DataUpdateGame;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "games")
@Entity(name = "Game")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Game {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String platform;
	private String stars;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	public Game(DataRegistrationGame data) {
		this.name = data.name();
		this.platform = data.platform();
		this.stars = data.stars();
		this.gender = data.gender();
	}

	public void updateGame(@Valid DataUpdateGame dataUpdateGame) {
		if (dataUpdateGame.name() != null) {
			this.name = dataUpdateGame.name();
		}
		
		if (dataUpdateGame.platform() != null) {
			this.platform = dataUpdateGame.platform();
		}
		
		if (dataUpdateGame.stars() != null) {
			this.stars = dataUpdateGame.stars();
		}
		
		if (dataUpdateGame.gender() != null) {
			this.gender = dataUpdateGame.gender();
		}
	}

}
