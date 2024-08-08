package WEEK1_DSA.DesignAndPatterns;

public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");
        
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Logger instances are different.");
        }
    }
}


class Logger {
    private static volatile Logger loggerInstance;

    private Logger() {}

    public static Logger getInstance() {
        if (loggerInstance == null) {
            synchronized (Logger.class) {
                if (loggerInstance == null) {
                    loggerInstance = new Logger();
                }
            }
        }
        return loggerInstance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
