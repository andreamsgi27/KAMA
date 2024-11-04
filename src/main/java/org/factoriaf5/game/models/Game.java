package org.factoriaf5.game.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Renombrado de gameId a id

    @NotNull(message = "El nombre del jugador no puede ser nulo")
    private String playerName;

    private Boolean gameCleared;

    @NotNull(message = "La puntuación final no puede ser nula")
    private Integer finalScore;

    @Column(name = "gameDate")
    private LocalDateTime gameDate; // Cambiado a LocalDateTime

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Boolean getGameCleared() {
        return gameCleared;
    }

    public void setGameCleared(Boolean gameCleared) {
        this.gameCleared = gameCleared;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    public LocalDateTime getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDateTime gameDate) {
        this.gameDate = gameDate;
    }
}
