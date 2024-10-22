package org.factoriaf5.game;

public class Items {
    private String itemName;

    public Items(String itemName) {
        this.itemName = itemName;
        }
        public String getItemName() {
            return itemName;
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
        if (Monster.getMonsterName().equals("Vampiro") && Monster.getLifeStealing() == true){
            Monster.setLifeStealing(false);
            System.out.println("El vampiro ya no puede robarte vida");

        } else {
            System.out.println("El ajo no puede usarse en este momento");
        }
    }

    public void glasses(){
        if (Monster.getMonsterName().equals("Fantasma") && Monster.getInvisibility() == true){
            Monster.setInvisibility(false);
            System.out.println("El fantasma ya no es invisible");
        } else {
            System.out.println("Las gafas no pueden usarse en este momento");
        }
    }

    public void whistle(){
        itemName = "Silbato";
        if (Monster.getMonsterName().equals("Esqueleto") && Monster.getNumSkeletons() >=2){
            Monster.setNumSkeletons = 1;
            System.out.println("Usas silbato y aparece un lobo enorme que se come a todos los esqueletos dejando solo a uno en pie");
        } else {
            System.out.println("El silbato no puede usarse en este momento");
        }
    }



}

