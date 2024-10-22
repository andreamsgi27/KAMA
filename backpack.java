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

    public void openBackpack() {
        if (itemsList.isEmpty()) {
            System.out.println("Tu mochila está vacía.");
        } else {
            System.out.println("Estos son tus objetos:");
            showItems();
            System.out.println("\n¿Quieres usar uno de los objetos? (s/n)");
            String useItems = scanner.nextLine();
            if (useItems.equalsIgnoreCase("s")) {
                System.out.println("Elige un objeto para usar:");
                int indice = scanner.nextInt();
                scanner.nextLine(); 
                useItem(indice);
            } else {
                takeDecision(); 
            }
        }
    }

    public void showItems() {
        for (int i = 0; i < itemsList.size(); i++) {
            System.out.println(i + ". " + itemsList.get(i).getItemName()); 
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
            int indice = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            deleteItem(indice);
            itemsList.add(newItem);
            System.out.println("Has reemplazado un objeto por " + newItem.getItemName());
        } else {
            System.out.println("Regresando al panel de decisiones...");
            takeDecision(); 
        }
    }
}