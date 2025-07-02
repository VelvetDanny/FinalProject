public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        manager.loadData();

        while (true) {
            System.out.println("\n1. Add Item to Inventory");
            System.out.println("2. Sell Item");
            System.out.println("3. View Inventory");
            System.out.println("4. View Sold-out Items");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = InputValidator.getUserInput();

            switch (choice) {
                case 1 -> manager.addItem();
                case 2 -> manager.sellItem();
                case 3 -> manager.displayInventory();
                case 4 -> manager.displaySoldOut();
                case 5 -> {
                    manager.saveData();
                    System.out.println("Exiting and saving data...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
