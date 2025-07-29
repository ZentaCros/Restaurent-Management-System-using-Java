import java.util.*;

public class MenuManagement {
    private TreeMap<String, LinkedList<MenuItem>> menu;

    public MenuManagement() {
        menu = new TreeMap<>();
        initializeMenu();
    }

    private void initializeMenu() {
        LinkedList<MenuItem> pizzas = new LinkedList<>(Arrays.asList(
                new MenuItem("Margherita", 8.99),
                new MenuItem("Fajita", 11.99),
                new MenuItem("Crown Crust", 13.99)
        ));

        LinkedList<MenuItem> burgers = new LinkedList<>(Arrays.asList(
                new MenuItem("Cheese Burger", 7.99),
                new MenuItem("Zinger Burger", 5.66)
        ));

        LinkedList<MenuItem> sides = new LinkedList<>(Arrays.asList(
                new MenuItem("Salted Fries", 2.99),
                new MenuItem("Garlic Bread", 4.99)

        ));

        LinkedList<MenuItem> drinks = new LinkedList<>(Arrays.asList(
                new MenuItem("Coke", 0.79),
                new MenuItem("Pespi", 0.79)

        ));
         LinkedList<MenuItem> shakes = new LinkedList<>(Arrays.asList(
                new MenuItem("Mango Shake", 3.99),
                new MenuItem("Strawberry Shake", 2.49)

        ));

        menu.put("Pizzas", pizzas);
        menu.put("Burgers", burgers);
        menu.put("Sides", sides);
        menu.put("Drinks", drinks);
        menu.put("Shakes", shakes);

    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (Map.Entry<String, LinkedList<MenuItem>> entry : menu.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (MenuItem item : entry.getValue()) {
                System.out.println("  - " + item.name + ": $" + item.price);
            }
        }
    }

    public MenuItem findMenuItem(String itemName) {
        for (LinkedList<MenuItem> items : menu.values()) {
            for (MenuItem item : items) {
                if (item.name.equalsIgnoreCase(itemName)) {
                    return item;
                }
            }
        }
        return null;
    }
}

class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
