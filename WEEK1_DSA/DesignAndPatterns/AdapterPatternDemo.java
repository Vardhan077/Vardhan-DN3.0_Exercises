// PaymentProcessor.java


// AdapterPatternDemo.java
public class AdapterPatternDemo {
    public static void main(String[] args) {
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();
        AmazonPay amazonPay = new AmazonPay();

        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);
        PaymentProcessor amazonPayProcessor = new AmazonPayAdapter(amazonPay);

        payPalProcessor.processPayment(100.00);
        stripeProcessor.processPayment(200.00);
        amazonPayProcessor.processPayment(300.00);
    }
}


interface PaymentProcessor {
    void processPayment(double amount);
}

// PayPal.java
class PayPal {
    public void makePayment(double amount) {
        System.out.println("Processing payment of Rs." + amount + " through PayPal.");
    }
}

// Stripe.java
class Stripe {
    public void pay(double amount) {
        System.out.println("Processing payment of Rs." + amount + " through Stripe.");
    }
}

// AmazonPay.java
class AmazonPay {
    public void processTransaction(double amount) {
        System.out.println("Processing payment of Rs." + amount + " through Amazon Pay.");
    }
}

// PayPalAdapter.java
class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

// StripeAdapter.java
class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}

// AmazonPayAdapter.java
class AmazonPayAdapter implements PaymentProcessor {
    private AmazonPay amazonPay;

    public AmazonPayAdapter(AmazonPay amazonPay) {
        this.amazonPay = amazonPay;
    }

    @Override
    public void processPayment(double amount) {
        amazonPay.processTransaction(amount);
    }
}