import java.util.*;

public class CustomerManagement {
    private LinkedList<Customer> customers;
    private TreeMap<Integer, Customer> customerMap;

    public CustomerManagement() {
        customers = new LinkedList<>();
        customerMap = new TreeMap<>();
    }

    public void registerCustomer(Customer customer) {
        customers.add(customer);
        customerMap.put(customer.id, customer);
        System.out.println("Customer registered successfully!");
    }

    public void updateCustomerInformation(Customer customer) {
        customerMap.put(customer.id, customer);
        System.out.println("Customer information is updated.");
    }

    public Customer searchCustomerById(int id) {
        return customerMap.get(id);
    }
}

class Customer {
    int id;
    String name;
    String phoneNumber;

    Customer(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
