

public class StrategyPatternDemo {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        paymentContext.setPaymentStrategy(new CreditCardPayment("John Doe", "1234567890123456", "123", "12/23"));
        paymentContext.executePayment(100.0);

        paymentContext.setPaymentStrategy(new PayPalPayment("john.doe@example.com", "password123"));
        paymentContext.executePayment(200.0);
    }
}


interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String name, String cardNumber, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of " + amount + " for " + name + ".");
        // Logic for credit card payment
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of " + amount + " from " + email + ".");
        // Logic for PayPal payment
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Payment strategy not set.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}