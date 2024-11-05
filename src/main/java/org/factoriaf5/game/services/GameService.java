package org.factoriaf5.game.services;

import org.factoriaf5.game.models.Game;
import org.factoriaf5.game.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

 
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    public Game updateGame(Long id, Game updatedGame) {
        return gameRepository.findById(id)
                .map(game -> {
                    game.setPlayerName(updatedGame.getPlayerName());
                    game.setGameCleared(updatedGame.getGameCleared());
                    game.setFinalScore(updatedGame.getFinalScore());
                    game.setGameDate(updatedGame.getGameDate());
                    return gameRepository.save(game);
                })
                .orElseThrow(() -> new RuntimeException("Game not found"));
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
