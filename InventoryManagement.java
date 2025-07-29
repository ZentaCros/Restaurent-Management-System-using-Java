import java.util.*;

public class InventoryManagement {
    private TreeMap<String, Integer> inventory;

    public InventoryManagement() {
        inventory = new TreeMap<>();
    }

    public void updateInventoryAfterOrder(String itemName, int quantity) {
        inventory.put(itemName, inventory.getOrDefault(itemName, 0) - quantity);
        System.out.println("Inventory updated for this item: " + itemName);
    }

    public void checkInventoryLevels() {
        System.out.println("Current Inventory Levels:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Item: " + entry.getKey() + " | Quantity: " + entry.getValue());
        }
    }

    public void restockInventory(String itemName, int quantity) {
        inventory.put(itemName, inventory.getOrDefault(itemName, 0) + quantity);
        System.out.println("Restocked item: " + itemName);
    }
}
