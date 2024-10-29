package org.factoriaf5.game.controllers;

import org.factoriaf5.game.models.Game; // Asegúrate de que Game esté en el paquete correcto
import org.factoriaf5.game.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@Validated @RequestBody Game game) {
        Game savedGame = gameRepository.save(game);
        return new ResponseEntity<>(savedGame, HttpStatus.CREATED);
    }
}
