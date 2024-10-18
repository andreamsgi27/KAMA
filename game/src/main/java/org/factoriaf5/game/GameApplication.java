package org.factoriaf5.game;

import java.sql.Connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
		Connection connection = DatabaseConnection.connect();
        if (connection != null) {
            CreateTable.createGamesTable(connection);  
        }
	}
}
