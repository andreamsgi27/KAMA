package org.factoriaf5.game.services;

import org.factoriaf5.game.models.Game;
import org.factoriaf5.game.repositories.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService gameService;

    private Game game;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        game = new Game();
        game.setId(1L);
        game.setPlayerName("Horse Luis");
        game.setGameCleared(true);
        game.setFinalScore(150);
        game.setGameDate(LocalDateTime.now());
    }

    @Test
    void testGetAllGames() {
        List<Game> games = Arrays.asList(game);
        when(gameRepository.findAll()).thenReturn(games);

        List<Game> result = gameService.getAllGames();

        assertEquals(1, result.size());
        assertEquals(game.getPlayerName(), result.get(0).getPlayerName());
        verify(gameRepository, times(1)).findAll();
    }

    @Test
    void testCreateGame() {
        when(gameRepository.save(game)).thenReturn(game);

        Game savedGame = gameService.createGame(game);

        assertNotNull(savedGame);
        assertEquals(game.getPlayerName(), savedGame.getPlayerName());
        verify(gameRepository, times(1)).save(game);
    }

    @Test
    void testGetGameByIdFound() {
        when(gameRepository.findById(1L)).thenReturn(Optional.of(game));

        Optional<Game> result = gameService.getGameById(1L);

        assertTrue(result.isPresent());
        assertEquals(game.getPlayerName(), result.get().getPlayerName());
        verify(gameRepository, times(1)).findById(1L);
    }

    @Test
    void testGetGameByIdNotFound() {
        when(gameRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Game> result = gameService.getGameById(1L);

        assertFalse(result.isPresent());
        verify(gameRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateGameFound() {
        Game updatedGame = new Game();
        updatedGame.setPlayerName("Horse Huan");
        updatedGame.setGameCleared(false);
        updatedGame.setFinalScore(200);
        updatedGame.setGameDate(LocalDateTime.now());

        when(gameRepository.findById(1L)).thenReturn(Optional.of(game));
        when(gameRepository.save(game)).thenReturn(game);

        Game result = gameService.updateGame(1L, updatedGame);

        assertEquals(updatedGame.getPlayerName(), result.getPlayerName());
        assertEquals(updatedGame.getGameCleared(), result.getGameCleared());
        assertEquals(updatedGame.getFinalScore(), result.getFinalScore());
        verify(gameRepository, times(1)).findById(1L);
        verify(gameRepository, times(1)).save(game);
    }

    @Test
    void testUpdateGameNotFound() {
        Game updatedGame = new Game();
        updatedGame.setPlayerName("Horse Huan");
        
        when(gameRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> gameService.updateGame(1L, updatedGame));
        verify(gameRepository, times(1)).findById(1L);
        verify(gameRepository, never()).save(any(Game.class));
    }

    @Test
    void testDeleteGame() {
        doNothing().when(gameRepository).deleteById(1L);

        gameService.deleteGame(1L);

        verify(gameRepository, times(1)).deleteById(1L);
    }
}
