package org.factoriaf5.game;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable {
    public static void createGamesTable(Connection connection) {
        String createTableSQL = "CREATE TABLE games (" +
                "gameId INT PRIMARY KEY AUTO_INCREMENT, " +
                "gameDate DATE, " +
                "playerName VARCHAR(255), " +
                "gameCleared BOOLEAN, " +
                "finalScore INT" +
                ");";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Tabla 'games' creada con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
}


