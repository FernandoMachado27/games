package br.com.fernando.games.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fernando.games.domain.game.DataRegistrationGame;
import br.com.fernando.games.domain.game.Game;
import br.com.fernando.games.domain.game.GameRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	private GameRepository gamesRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid DataRegistrationGame dataRegistrationGame, UriComponentsBuilder uriBuilder){
		var game = new Game(dataRegistrationGame);
		gamesRepository.save(game);
		
		var uri = uriBuilder.path("/medico/{id}").buildAndExpand(game.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DataDetailsGame(game));
	}

}
