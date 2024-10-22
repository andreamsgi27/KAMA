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
            System.out.println("Your backpack is empty.");
        } else {
            System.out.println("These are your items:");
            showItems();
            System.out.println("\nDo you want to use one of the items? (y/n)");
            String useItems = scanner.nextLine();
            if (useItems.equalsIgnoreCase("y")) {
                System.out.println("Choose an item to use:");
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
            System.out.println(item.getItemName() + " has been added to the backpack.");
        }
    }

    public void deleteItem(int indice) {
        if (indice >= 0 && indice < itemsList.size()) {
            Items item = itemsList.get(indice);
            itemsList.remove(indice);
            System.out.println(item.getItemName() + " was deleted.");
        } else {
            System.out.println("Choose an item that exists.");
        }
    }

    public boolean backpackFull() {
        return itemsList.size() >= backpackCapacity;
    }

    private void changeItem(Items newItem) {  // Cambiado a Items
        System.out.println("Your backpack is full. Do you want to replace an item from your backpack for the new item? (y/n)?");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            showItems();
            System.out.println("\nChoose the item you want to replace:");
            int indice = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            deleteItem(indice);
            itemsList.add(newItem);
            System.out.println("You have replaced an item with " + newItem.getItemName());
        } else {
            System.out.println("Returning to decision panel...");
            takeDecision();
        }
    }
}
