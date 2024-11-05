package org.factoriaf5.game;

import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    public static void main(String[] args) {
        // Inicializar el array de eventos
        String[] arrayEvents = {"M", "M", "M", "M", "M", "O", "O", "O", "E", "E"};

        // Mezclar los elementos aleatoriamente
        List<String> shuffledList = Arrays.asList(arrayEvents);
        Collections.shuffle(shuffledList);
        String[] shuffledArray = shuffledList.toArray(new String[0]);

        // Crear el scanner y el índice
        Scanner scanner = new Scanner(System.in);
        int index = 0;

        // Bucle del juego
        while (index < shuffledArray.length) {
            System.out.println("Introduce una dirección (W para arriba, A para izquierda, D para derecha): ");
            String input = scanner.nextLine().toUpperCase();

            // Verificar que el input es válido
            if (input.equals("W") || input.equals("A") || input.equals("D")) {
                // Ejecutar la función correspondiente según el evento
                switch (shuffledArray[index]) {
                    case "M":
                        funcionM();
                        break;
                    case "O":
                        funcionO();
                        break;
                    case "E":
                        funcionE();
                        break;
                }
                index++;
            } else {
                System.out.println("Entrada no válida. Inténtalo de nuevo.");
            }
        }

        System.out.println("Has completado el nivel");
        scanner.close();
    }

    // Funciones de eventos
    public static void funcionM() {
        System.out.println("Función M: ¡Un monstruo te ataca!.");
    }

    public static void funcionO() {
        System.out.println("Función O: Has encontrado un objeto.");
    }

    public static void funcionE() {
        System.out.println("Función E: \"Arancha: 'Cada paso que das fortalece la oscuridad, pero recuerda que la esperanza vive en ti.'\"");
    }
}


    /* 
    
    String[] loreArray = {
        "Arancha: 'Aiden, en lo profundo del bosque, oigo voces antiguas... algo oscuro te aguarda.'",
        "Anaís: 'Mortis ha desatado sus criaturas, y solo tú, Aiden, puedes devolver la paz.'",
        "Arancha: 'Cada paso que das fortalece la oscuridad, pero recuerda que la esperanza vive en ti.'",
        "Anaís: 'En el valle oscuro, encontrarás una llave ancestral... úsala sabiamente.'",
        "Arancha: 'Las sombras susurran tu nombre, Aiden... pisa con cautela.'",
        "Anaís: 'Esta linterna que llevas es la última luz de nuestro pueblo... protégela.'",
        "Arancha: 'Los espíritus de los guardianes están a tu lado, ellos te guiarán en la oscuridad.'",
        "Anaís: 'Nuestros ancestros lucharon valientemente, Aiden, y su espíritu vive en ti.'",
        "Arancha: 'El sacrificio de uno puede salvar el alma de todos, no lo olvides.'",
        "Anaís: 'Mortis te teme, Aiden. En tu interior llevas algo que su oscuridad no puede tocar.'"
    }
    
 */
