

package org.factoriaf5.game;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class GameMenu {

    private String inputPlayerName; // Variable para almacenar el nombre del jugador

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenú principal:");
            System.out.println("1. Iniciar juego");
            System.out.println("2. Ver tabla de juegos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    initGame(scanner); 
                    break;
                case 2:
                    openGamesTable();
                    break;
                case 3:
                    System.out.println("Saliendo del juego...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (option != 3);

        scanner.close();
    }

    public void initGame(Scanner scanner) {
        System.out.print("Ingrese el nombre del jugador: ");
        inputPlayerName = scanner.nextLine();
        System.out.println("Jugador registrado: " + inputPlayerName);
        // Aquí queda guardado el nombre del jugador
    }

    public void openGamesTable() {
        String url = "http://localhost:8080/games";
        System.out.println("Acceda a la tabla de juegos en el siguiente enlace:");
        System.out.println(url);
    
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                System.out.println("No se pudo abrir el navegador automáticamente: " + e.getMessage());
            }
        } else {
            System.out.println("La apertura automática del navegador no es compatible en este sistema.");
        }
    }    
}
