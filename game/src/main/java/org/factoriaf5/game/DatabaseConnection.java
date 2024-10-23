package org.factoriaf5.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:h2:file:./gamesDB";
    // la rula relativa en el portátil de F5 es jdbc:h2:file:C:/Users/CODER F5 ASTURIAS/Desktop/factoria-f5/kama/KAMA/game/gamesDB
    // Ruta relativa en h2 console en el PC de casa jdbc:h2:file:C:/Users/Admin/ironhack/KAMA/gamesDB

    // (la que hay que poner en h2 console para visualizar la base de datos)
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a la base de datos establecida.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }
}
