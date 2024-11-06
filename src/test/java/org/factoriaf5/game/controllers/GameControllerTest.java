package org.factoriaf5.game.controllers;

import org.factoriaf5.game.models.Game;
import org.factoriaf5.game.services.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GameController.class)
class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
        game.setId(1L);
        game.setPlayerName("Horse Luis");
        game.setGameCleared(true);
        game.setFinalScore(100);
        game.setGameDate(LocalDateTime.now());
    }

    @Test
    void getAllGames_ShouldReturnListOfGames() throws Exception {
        when(gameService.getAllGames()).thenReturn(Arrays.asList(game));

        mockMvc.perform(get("/games"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(game.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].playerName").value(game.getPlayerName()));
        
        verify(gameService, times(1)).getAllGames();
    }

    @Test
    void createGame_ShouldReturnCreatedGame() throws Exception {
        when(gameService.createGame(any(Game.class))).thenReturn(game);

        mockMvc.perform(post("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"playerName\": \"Horse Luis\", \"gameCleared\": true, \"finalScore\": 100 }"))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(game.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.playerName").value(game.getPlayerName()));
        
        verify(gameService, times(1)).createGame(any(Game.class));
    }

    @Test
    void getGameById_ShouldReturnGameWhenExists() throws Exception {
        when(gameService.getGameById(1L)).thenReturn(Optional.of(game));

        mockMvc.perform(get("/games/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(game.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.playerName").value(game.getPlayerName()));
        
        verify(gameService, times(1)).getGameById(1L);
    }

    @Test
    void getGameById_ShouldReturnNotFoundWhenDoesNotExist() throws Exception {
        when(gameService.getGameById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/games/1"))
                .andExpect(status().isNotFound());
        
        verify(gameService, times(1)).getGameById(1L);
    }

    @Test
    void updateGame_ShouldReturnUpdatedGameWhenExists() throws Exception {
        when(gameService.updateGame(eq(1L), any(Game.class))).thenReturn(game);

        mockMvc.perform(put("/games/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"playerName\": \"Horse Huan\", \"gameCleared\": false, \"finalScore\": 200 }"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(game.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.playerName").value("Horse Luis")); 

        verify(gameService, times(1)).updateGame(eq(1L), any(Game.class));
    }

    @Test
    void updateGame_ShouldReturnNotFoundWhenGameDoesNotExist() throws Exception {
        when(gameService.updateGame(eq(1L), any(Game.class))).thenThrow(new RuntimeException("Game not found"));

        mockMvc.perform(put("/games/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"playerName\": \"Horse Huan\", \"gameCleared\": false, \"finalScore\": 200 }"))
                .andExpect(status().isNotFound());
        
        verify(gameService, times(1)).updateGame(eq(1L), any(Game.class));
    }

    @Test
    void deleteGame_ShouldReturnNoContent() throws Exception {
        doNothing().when(gameService).deleteGame(1L);

        mockMvc.perform(delete("/games/1"))
                .andExpect(status().isNoContent());

        verify(gameService, times(1)).deleteGame(1L);
    }
}
