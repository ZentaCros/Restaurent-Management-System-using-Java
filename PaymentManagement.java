import java.util.*;

public class PaymentManagement {
    private Stack<PaymentTransaction> paymentStack;

    public PaymentManagement() {
        paymentStack = new Stack<>();
    }

    public void processPayment(PaymentTransaction transaction) {
        paymentStack.push(transaction);
        System.out.println("Payment processed for this Order ID: " + transaction.orderId);
    }

    public void refundPayment() {
        if (!paymentStack.isEmpty()) {
            PaymentTransaction transaction = paymentStack.pop();
            System.out.println("Refund processed for this Order ID: " + transaction.orderId);
        } else {
            System.out.println("No transactions to refund.");
        }
    }
}

class PaymentTransaction {
    int orderId;
    double amount;

    PaymentTransaction(int orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }
}
