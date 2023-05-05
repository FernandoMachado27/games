package br.com.fernando.games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity register(@RequestBody @Valid DataRegistrationGame dataRegistrationGame, UriComponentsBuilder uriBuilder){
		var game = new Game(dataRegistrationGame);
		gamesRepository.save(game);
		
		var uri = uriBuilder.path("/medico/{id}").buildAndExpand(game.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DataDetailsGame(game));
	}
	
	@GetMapping
	public ResponseEntity<List<DataDetailsGame>> list(){
		var games = gamesRepository.findAll().stream().map(DataDetailsGame::new).toList();
		
		return ResponseEntity.ok(games);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable Long id) {
		var game = gamesRepository.getReferenceById(id);
		gamesRepository.delete(game);
		return ResponseEntity.noContent().build();
	}

}
