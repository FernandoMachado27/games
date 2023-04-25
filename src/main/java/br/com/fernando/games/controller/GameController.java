package br.com.fernando.games.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.games.domain.game.GameRepository;

@RestController
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	private GameRepository gamesRepository;

}
