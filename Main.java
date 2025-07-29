import java.util.*;

public class Main {

    public static void main(String[] args) {
        MenuManagement menuManagement = new MenuManagement();
        OrderManagement orderManagement = new OrderManagement();
        CustomerManagement customerManagement = new CustomerManagement();
        InventoryManagement inventoryManagement = new InventoryManagement();
        PaymentManagement paymentManagement = new PaymentManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Enter New Order");
            System.out.println("2. View Your Current Orders");
            System.out.println("3. Process Next Orders");
            System.out.println("4. Register Customer");
            System.out.println("5. Update Customer Information");
            System.out.println("6. Search Customer by ID");
            System.out.println("7. Check Inventory Levels");
            System.out.println("8. Restock Inventory");
            System.out.println("9. Process Payment");
            System.out.println("10. Refund customer Payment");
            System.out.println("11. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    List<OrderItem> orderedItems = new LinkedList<>();
                    String continueOrder;

                    do {
                        menuManagement.displayMenu();
                        System.out.println("Enter the item name to order:");
                        String itemName = scanner.nextLine();
                        MenuItem menuItem = menuManagement.findMenuItem(itemName);

                        if (menuItem != null) {
                            System.out.println("Enter quantity for " + itemName + ":");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();  // Consume newline

                            orderedItems.add(new OrderItem(menuItem, quantity));
                            inventoryManagement.updateInventoryAfterOrder(itemName, quantity);
                            System.out.println(itemName + " added to your order with quantity " + quantity + ".");
                        } else {
                            System.out.println("Item not found. Please try again.");
                        }

                        System.out.println("Would you like to add another item? (yes/no)");
                        continueOrder = scanner.nextLine().toLowerCase();

                    } while (continueOrder.equals("yes"));

                    orderManagement.placeNewOrder(orderedItems);
                    break;

                case 2:
                    orderManagement.viewCurrentOrders();
                    break;

                case 3:
                    orderManagement.processNextOrder();
                    break;

                case 4:
                    System.out.println("Enter Customer ID:");
                    int customerId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter Customer Name:");
                    String customerName = scanner.nextLine();
                    System.out.println("Enter Customer Phone Number:");
                    String phoneNumber = scanner.nextLine();

                    Customer customer = new Customer(customerId, customerName, phoneNumber);
                    customerManagement.registerCustomer(customer);
                    break;

                case 5:
                    System.out.println("Enter Customer ID to update:");
                    int updateCustomerId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter updated Customer Name:");
                    String updateCustomerName = scanner.nextLine();
                    System.out.println("Enter updated Customer Address:");
                    String updatephoneNumber = scanner.nextLine();

                    Customer updatedCustomer = new Customer(updateCustomerId, updateCustomerName, updatephoneNumber);
                    customerManagement.updateCustomerInformation(updatedCustomer);
                    break;

                case 6:
                    System.out.println("Enter Customer ID to search:");
                    int searchCustomerId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    Customer searchedCustomer = customerManagement.searchCustomerById(searchCustomerId);
                    if (searchedCustomer != null) {
                        System.out.println("Customer ID: " + searchedCustomer.id);
                        System.out.println("Customer Name: " + searchedCustomer.name);
                        System.out.println("Customer Address: " + searchedCustomer.phoneNumber);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 7:
                    inventoryManagement.checkInventoryLevels();
                    break;

                case 8:
                    System.out.println("Enter the item name to restock:");
                    String restockItemName = scanner.nextLine();
                    System.out.println("Enter quantity to restock:");
                    int restockQuantity = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    inventoryManagement.restockInventory(restockItemName, restockQuantity);
                    break;

                case 9:
                    System.out.println("Enter Order ID for payment:");
                    int paymentOrderId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter payment amount:");
                    double paymentAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    PaymentTransaction paymentTransaction = new PaymentTransaction(paymentOrderId, paymentAmount);
                    paymentManagement.processPayment(paymentTransaction);
                    break;

                case 10:
                    paymentManagement.refundPayment();
                    break;

                case 11:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
