package org.factoriaf5.game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertGame {

    public static void insertGame(Connection connection, String gameDate, String playerName, boolean gameCleared, int finalScore) {
        String insertSQL = "INSERT INTO games (gameDate, playerName, gameCleared, finalScore) VALUES (?, ?, ?, ?);";

        // aquí se cambiarían los datos con los respectivos gets de Aiden y el nombre del jugador quizás también mejor preguntarlo aquí? (o al empezar la partida)
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, gameDate); // quizás usar un setDate en este parámetro?
            preparedStatement.setString(2, playerName);
            preparedStatement.setBoolean(3, gameCleared);
            preparedStatement.setInt(4, finalScore);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Registro insertado con éxito.");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar guardar la puntuación de tu partida, debido a: " + e.getMessage());
        }
    }
}
