package org.factoriaf5.game;
import org.factoriaf5.game.Items;
import org.factoriaf5.game.Aiden;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Backpack {
    private List<Items> itemsList;  
    private final int backpackCapacity = 3;
    private Scanner scanner;

    public Backpack() {
        itemsList = new ArrayList<>();
        scanner = new Scanner(System.in); 
    }

    public void useItem(int index, Aiden aiden) {
        if (index >= 0 && index < itemsList.size()) {
            Items item = itemsList.get(index);
            String itemName = item.getItemName();
    
            switch (itemName) {
                case "Lanza":
                    int totalDamage = item.Spear(aiden.getAidenDamage()); 
                    aiden.setAidenDamage(totalDamage);  
                    break;
                case "Poción":
                    int totalHealth = item.Potion(aiden.getAidenHealth());  
                    aiden.setAidenHealth(totalHealth);  
                    break;
                case "Ajo":
                    item.garlic();  
                    break;
                case "Gafas":
                    item.glasses();  
                    break;
                case "Silbato":
                    item.whistle(); 
                    break;
                default:
                    System.out.println("El objeto no tiene un uso definido.");
            }
        } else {
            System.out.println("Elige un objeto válido.");
        }
    }    

    public void openBackpack(Aiden aiden) {
        if (itemsList.isEmpty()) {
            System.out.println("Tu mochila está vacía.");
        } else {
            System.out.println("Estos son tus objetos:");
            showItems();
            System.out.println("\n¿Quieres usar uno de los objetos? (s/n)");
            String useItems = scanner.nextLine();
            if (useItems.equalsIgnoreCase("s")) {
                System.out.println("Elige un objeto para usar (elige el número correspondiente):");
                int indice = scanner.nextInt() - 1;
                scanner.nextLine(); 
                useItem(indice, aiden);
            } else {
                takeDecision(); 
            }
        }
    }

    public void showItems() {
        for (int i = 0; i < itemsList.size(); i++) {
            System.out.println((i + 1) + ". " + itemsList.get(i).getItemName()); 
        }
    }

    public void addItem(Items item) {  
        if (backpackFull()) {
            changeItem(item);
        } else {
            itemsList.add(item);
            System.out.println(item.getItemName() + " ha sido añadido a la mochila.");
        }
    }

    public void deleteItem(int indice) {
        if (indice >= 0 && indice < itemsList.size()) {
            Items item = itemsList.get(indice);  
            itemsList.remove(indice);
            System.out.println(item.getItemName() + " ha sido eliminado.");
        } else {
            System.out.println("Elige un objeto que exista.");
        }
    }

    public boolean backpackFull() {
        return itemsList.size() >= backpackCapacity;
    }

    private void changeItem(Items newItem) {  
        System.out.println("Tu mochila está llena. ¿Quieres reemplazar un objeto de tu mochila por el nuevo objeto? (s/n)?");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("s")) {
            showItems();
            System.out.println("\nElige el objeto que quieres reemplazar:");
            int indice = scanner.nextInt() - 1; 
            scanner.nextLine();
            deleteItem(indice);
            itemsList.add(newItem);
            System.out.println("Has reemplazado un objeto por " + newItem.getItemName());
        } else {
            System.out.println("Regresando al panel de decisiones...");
            takeDecision(); 
        }
    } */
}
