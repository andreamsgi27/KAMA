package org.factoriaf5.game;

import java.util.ArrayList;
import java.util.Collections;

public class Levels {

    public static void Nivel1BosqueEncantado(ArrayList<String> events) {
        ArrayList<String> eventTypes = new ArrayList<>();
        eventTypes.add("Combate con los esqueletos");
        eventTypes.add("Encontraste un objeto mágico");
        eventTypes.add("Enfrenta al monstruo del bosque");
        
        Collections.shuffle(eventTypes);
        events.set(0, eventTypes.get(0) + ", " + eventTypes.get(1) + ", " + eventTypes.get(2));
    }



    public static void Nivel2CementerioOlvidado(ArrayList<String> events) {
        ArrayList<String> eventTypes = new ArrayList<>();
        eventTypes.add("combate con los fantasmas");
        eventTypes.add("Encontraste un objeto mágico");
        eventTypes.add("Enfrenta al monstruo del cementerio");
        
        Collections.shuffle(eventTypes);
        events.set(0, eventTypes.get(0) + ", " + eventTypes.get(1) + ", " + eventTypes.get(2));
    }

    
    public static void Nivel3CastillosDeMortis(ArrayList<String> events) {
        ArrayList<String> eventTypes = new ArrayList<>();
        eventTypes.add("duelo con los vampiros");
        eventTypes.add("Encontraste un objeto mágico");
        eventTypes.add("duelo con monstruos del castillo");
        
        Collections.shuffle(eventTypes);
        events.set(0, eventTypes.get(0) + ", " + eventTypes.get(1) + ", " + eventTypes.get(2));
    }

    
    public static void main(String[] args) {
        ArrayList<String> bosqueEncantado = new ArrayList<>();
        ArrayList<String> cementerioOlvidado = new ArrayList<>();
        ArrayList<String> castilloDeMortis = new ArrayList<>();
        
        bosqueEncantado.add("");
        cementerioOlvidado.add("");
        castilloDeMortis.add("");

    
        System.out.println("Eventos Bosque Encantado:");
        Nivel1BosqueEncantado(bosqueEncantado);
        System.out.println(bosqueEncantado);

        
        System.out.println("\nEventos Cementerio Olvidado:");
        Nivel2CementerioOlvidado(cementerioOlvidado);
        System.out.println(cementerioOlvidado);

        
        System.out.println("\nEventos Castillo de Mortis:");
        Nivel3CastillosDeMortis(castilloDeMortis);
        System.out.println(castilloDeMortis);
    }
}
