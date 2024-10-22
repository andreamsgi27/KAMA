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
        System.out.println("Aiden usa una lanza con" + swordDamage + " de daño.");
        System.out.println("Aiden inflige" + totalDamage + " de daño");
        return totalDamage;
    }
    public int potion (int aidenHealth) {
        itemName = "Poción";
        int potion = 20;
        int totalHealth = aidenHealth + potion;
        System.out.println("Aiden usa una poción con" + potion + " de vida");
        System.out.println("Aiden tiene ahora" + totalHealth + " de vida");
        return  totalHealth;
    }

    public void garlic(){
        itemName = "Ajo";
        if (Monster.getMonsterName().equals("Vampiro") && Monster.getLifeStealing() == true){
            Monster.setLifeStealing(false);
        } else {
            System.out.println("El ajo no puede usarse");
        }
    }

    public void glasses(){
        if (Monster.getMonsterName().equals("Fantasma") && Monster.getInvisibility() == true){
            Monster.setInvisibility(false);
        } else {
            System.out.println("Las gafas no pueden usarse");
        }
    }

    public void whistle(){
        itemName = "Silbato";
        if (Monster.getMonsterName().equals("Esqueleto") && Monster.getNumSkeletons() >=2){
            Monster.setNumSkeletons = 1;
        }
    }



}

