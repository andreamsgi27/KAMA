package org.factoriaf5.game.models;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;
    private Validator validator;

    @BeforeEach
    void setUp() {
        game = new Game();
        game.setId(1L);
        game.setPlayerName("Horse Luis");
        game.setGameCleared(true);
        game.setFinalScore(150);
        game.setGameDate(LocalDateTime.now());

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testGettersAndSetters() {
        assertEquals(1L, game.getId());
        assertEquals("Horse Luis", game.getPlayerName());
        assertTrue(game.getGameCleared());
        assertEquals(150, game.getFinalScore());
        assertNotNull(game.getGameDate());
    }

    @Test
    void testPlayerNameNotNull() {
        game.setPlayerName(null);
        Set<ConstraintViolation<Game>> violations = validator.validate(game);

        assertFalse(violations.isEmpty());
        assertEquals("El nombre del jugador no puede ser nulo", 
                     violations.iterator().next().getMessage());
    }

    @Test
    void testFinalScoreNotNull() {
        game.setFinalScore(null);
        Set<ConstraintViolation<Game>> violations = validator.validate(game);

        assertFalse(violations.isEmpty());
        assertEquals("La puntuación final no puede ser nula", 
                     violations.iterator().next().getMessage());
    }

    @Test
    void testGameClearedSetterAndGetter() {
        game.setGameCleared(false);
        assertFalse(game.getGameCleared());
    }

    @Test
    void testGameDateSetterAndGetter() {
        LocalDateTime newDate = LocalDateTime.of(2023, 11, 5, 10, 30);
        game.setGameDate(newDate);
        assertEquals(newDate, game.getGameDate());
    }

    @Test
    void testAllFieldsValid() {
        Set<ConstraintViolation<Game>> violations = validator.validate(game);
        assertTrue(violations.isEmpty());
    }
}
