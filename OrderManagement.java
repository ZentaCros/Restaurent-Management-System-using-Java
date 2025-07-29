import java.util.*;

public class OrderManagement {
    private Queue<Order> orderQueue;
    private int orderIdCounter;

    public OrderManagement() {
        orderQueue = new LinkedList<>();
        orderIdCounter = 1;
    }

    public void placeNewOrder(List<OrderItem> items) {
        Order newOrder = new Order(orderIdCounter++, items);
        orderQueue.add(newOrder);
        System.out.println("Your Order placed successfully! Order ID: " + newOrder.orderId);
    }

    public void viewCurrentOrders() {
        if (orderQueue.isEmpty()) {
            System.out.println("No current orders.");
        } else {
            System.out.println("Current Orders:");
            for (Order order : orderQueue) {
                System.out.println("Order ID: " + order.orderId + " | Total Price: $" + order.totalPrice);
            }
        }
    }

    public void processNextOrder() {
        if (orderQueue.isEmpty()) {
            System.out.println("No orders to process.");
        } else {
            Order nextOrder = orderQueue.poll();
            System.out.println("Processing Order ID: " + nextOrder.orderId + " | Total Price: $" + nextOrder.totalPrice);
        }
    }
}

class Order {
    int orderId;
    List<OrderItem> items;
    double totalPrice;

    Order(int orderId, List<OrderItem> items) {
        this.orderId = orderId;
        this.items = items;
        this.totalPrice = calculateTotal();
    }

    private double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.menuItem.price * item.quantity;
        }
        return total;
    }
}

class OrderItem {
    MenuItem menuItem;
    int quantity;

    OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }
}
