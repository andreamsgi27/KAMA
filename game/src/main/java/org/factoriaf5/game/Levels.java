package org.factoriaf5.game;
import java.util.ArrayList;
import java.util.Collections;

public class Levels {

    public static void fillAndRandomizeEvents(ArrayList<String> events) {

        ArrayList<String> eventTypes = new ArrayList<>();
        eventTypes.add("Combat");
        eventTypes.add("Item");
        eventTypes.add("Random Event");
        
        
        Collections.shuffle(eventTypes); 
        events.set(0, eventTypes.get(0) + ", " + eventTypes.get(1) + ", " + eventTypes.get(2));
    }

    public static void main(String[] args) {
    
        ArrayList<String> enchantedForest = new ArrayList<>();
        ArrayList<String> forgottenCemetery = new ArrayList<>();
        ArrayList<String> castlesOfMortis = new ArrayList<>();
        
    
        enchantedForest.add("");
        forgottenCemetery.add("");
        castlesOfMortis.add("");
        
    
        System.out.println("Filling Enchanted Forest events:");
        fillAndRandomizeEvents(enchantedForest);
        System.out.println(enchantedForest);

        System.out.println("\nFilling Forgotten Cemetery events:");
        fillAndRandomizeEvents(forgottenCemetery);
        System.out.println(forgottenCemetery);

        System.out.println("\nFilling Castles of Mortis events:");
        fillAndRandomizeEvents(castlesOfMortis);
        System.out.println(castlesOfMortis);
    }
}



