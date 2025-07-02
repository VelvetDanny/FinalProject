import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {
    private ArrayList<String> inventory = new ArrayList<>();
    private String[] soldOut = new String[100];
    private int soldOutIndex = 0;
    private final String INVENTORY_FILE = "inventory.txt";
    private final String SOLD_FILE = "soldout.txt";

    public void loadData() {
        inventory = FileHandler.loadList(INVENTORY_FILE);
        ArrayList<String> soldList = FileHandler.loadList(SOLD_FILE);
        for (String item : soldList) {
            if (soldOutIndex < soldOut.length) soldOut[soldOutIndex++] = item;
        }
    }

    public void saveData() {
        FileHandler.saveList(inventory, INVENTORY_FILE);
        ArrayList<String> soldList = new ArrayList<>();
        for (int i = 0; i < soldOutIndex; i++) soldList.add(soldOut[i]);
        FileHandler.saveList(soldList, SOLD_FILE);
    }

    public void addItem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter item name: ");
        String item = sc.nextLine();
        inventory.add(item);
        System.out.println("Item added.");
    }

    public void sellItem() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory empty.");
            return;
        }
        displayInventory();
        System.out.print("Enter item index to sell: ");
        int index = InputValidator.getUserInput();
        try {
            String item = inventory.remove(index);
            if (soldOutIndex < soldOut.length) soldOut[soldOutIndex++] = item;
            System.out.println("Item sold.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index.");
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i + ": " + inventory.get(i));
        }
    }

    public void displaySoldOut() {
        System.out.println("Sold-out Items:");
        for (int i = 0; i < soldOutIndex; i++) {
            System.out.println(i + ": " + soldOut[i]);
        }
    }
}
