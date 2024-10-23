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

    
    public static ArrayList<String> Level1BosqueEncantado() {
        return EnventGenerator();
    }

    
    public static ArrayList<String> Level2CementerioOlvidado() {
        return EnventGenerator();
    }

    
    public static ArrayList<String> Level3CastillosDeMortis() {
        return EnventGenerator();
    }


    public static void runlevels() {
        int actualLevel = 1;

        while (actualLevel <= 3) {
            ArrayList<String> levelsEvents = new ArrayList<>();

            switch (actualLevel) {
                case 1 -> levelsEvents = Level1BosqueEncantado();
                case 2 -> levelsEvents = Level2CementerioOlvidado();
                case 3 -> levelsEvents = Level3CastillosDeMortis();
            }

    
            for (String events : levelsEvents) {


                System.out.println(events); //revisar esta linea bien
                
            }

            actualLevel++;
        }
    }
}


    
    
        






