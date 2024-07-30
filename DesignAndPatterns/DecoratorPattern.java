

public class DecoratorPattern {
    public static void main(String[] args) {
        // Create a basic email notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate it with SMS functionality
        Notifier smsNotifier = new SmsNotifierDecorator(emailNotifier);

        // Further decorate it with Slack functionality
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send a notification using all the combined functionalities
        slackNotifier.send("Hello, this is a test notification!");
    }
}



interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

// Abstract decorator class that implements Notifier
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    // Delegates the send operation to the wrapped notifier
    public void send(String message) {
        notifier.send(message);
    }
}

// Concrete decorator that adds SMS notification functionality
class SmsNotifierDecorator extends NotifierDecorator {
    public SmsNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        notifier.send(message); // Send the base notification
        sendSms(message);       // Add SMS notification
    }

    private void sendSms(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

// Concrete decorator that adds Slack notification functionality
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        notifier.send(message); // Send the base notification
        sendSlack(message);     // Add Slack notification
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack notification: " + message);
    }
}
