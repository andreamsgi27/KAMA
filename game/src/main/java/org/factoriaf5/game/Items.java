package org.factoriaf5.game;

import java.rmi.server.Skeleton;
import java.util.Random;

public class Items {
    private String itemName;
    Backpack backpack = new Backpack();

    public Items(String itemName) {
        this.itemName = itemName;
        }
        public String getItemName() {
            return itemName;
        }
    
    public void itemFound () {
        Random random = new Random();
        String[] possibleItems = {"Lanza", "Poción", "Ajo", "Gafas", "Silbato"};
        String randomItem = possibleItems[random.nextInt(possibleItems.length)];
        System.out.println("Encontraste " + randomItem);
        Items foundItem = new Items(randomItem);
        backpack.addItem(foundItem); //randomItem es de tipo String
    }

    public int spear (int aidenDamage) {
        itemName = "Lanza";
        int swordDamage = 10;
        int totalDamage  = swordDamage + aidenDamage;
        System.out.println("Usas una lanza con" + swordDamage + " de daño.");
        System.out.println("Infliges" + totalDamage + " de daño");
        return totalDamage;
    }
    public int potion (int aidenHealth) {
        itemName = "Poción";
        int potion = 20;
        int totalHealth = aidenHealth + potion;
        System.out.println("Usas una poción con" + potion + " de vida");
        System.out.println("Ahora tienes" + totalHealth + " puntos de vida");
        return totalHealth;
    }

    public void garlic(){
        itemName = "Ajo";
        if (Vampire.getMonsterName().equalsIgnoreCase("Vampiro") && Vampire.getLifeStealing() == true){
            Vampire.setLifeStealing(false);
            System.out.println("El vampiro ya no puede robarte vida");

        } else {
            System.out.println("El ajo no puede usarse en este momento");
        }
    }

    public void glasses(){
        if (Phantom.getMonsterName().equalsIgnoreCase("Fantasma") && Phantom.getInvisibility() == true){
            Phantom.setInvisibility(false);
            System.out.println("El fantasma ya no es invisible");
        } else {
            System.out.println("Las gafas no pueden usarse en este momento");
        }
    }

    public void whistle(){
        itemName = "Silbato";
        if (Skeleton.getMonsterName().equalsIgnoreCase("Esqueleto") && Skeleton.getNumSkeletons() >=2){
            Skeleton.setNumSkeletons = 1;
            System.out.println("Usas silbato y aparece un lobo enorme que se come a todos los esqueletos dejando solo a uno en pie");
        } else {
            System.out.println("El silbato no puede usarse en este momento");
        }
    }



}
