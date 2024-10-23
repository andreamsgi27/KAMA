package org.factoriaf5.game;

import java.util.ArrayList;
import java.util.Collections;

public class Levels {

    
    public static ArrayList<String> EnventGenerator() {
        ArrayList<String> events = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            events.add("Combate " + (i + 1));
        }

        for (int i = 0; i < 3; i++) {
            events.add("Evento Aleatorio " + (i + 1));
        }

    
        for (int i = 0; i < 2; i++) {
            events.add("Objeto " + (i + 1));
        }

    
        Collections.shuffle(events);

        return events;
    }

    
    public static ArrayList<String> Nivel1BosqueEncantado() {
        return EnventGenerator();
    }

    
    public static ArrayList<String> Nivel2CementerioOlvidado() {
        return EnventGenerator();
    }

    
    public static ArrayList<String> Nivel3CastillosDeMortis() {
        return EnventGenerator();
    }


    public static void ejecutarNiveles() {
        int nivelActual = 1;

        while (nivelActual <= 3) {
            ArrayList<String> eventosNivel = new ArrayList<>();

            switch (nivelActual) {
                case 1 -> eventosNivel = Nivel1BosqueEncantado();
                case 2 -> eventosNivel = Nivel2CementerioOlvidado();
                case 3 -> eventosNivel = Nivel3CastillosDeMortis();
            }

    
            for (String events : eventosNivel) {


                System.out.println(events); //revisar esta linea bien
                
            }

            nivelActual++;
        }
    }
}


    
    
        






