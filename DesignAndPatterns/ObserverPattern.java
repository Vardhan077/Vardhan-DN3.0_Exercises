import java.util.ArrayList;
import java.util.List;


public class ObserverPattern {
    public static void main(String[] args) {
        StockMarketSubject stockMarket = new StockMarketSubject();

        StockObserver mobileObserver = new MobileStockObserver("MobileApp");
        StockObserver webObserver = new WebStockObserver("WebApp");

        stockMarket.registerObserver(mobileObserver);
        stockMarket.registerObserver(webObserver);

        stockMarket.setStockPrice(100.00);
        stockMarket.setStockPrice(101.50);

        stockMarket.deregisterObserver(webObserver);
        stockMarket.setStockPrice(102.75);
    }
}



interface StockSubject {
    void registerObserver(StockObserver observer);
    void deregisterObserver(StockObserver observer);
    void notifyObservers();
}

class StockMarketSubject implements StockSubject {
    private List<StockObserver> observers;
    private double stockPrice;

    public StockMarketSubject() {
        this.observers = new ArrayList<>();
    }

    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void deregisterObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}

interface StockObserver {
    void update(double stockPrice);
}

class MobileStockObserver implements StockObserver {
    private String appName;

    public MobileStockObserver(String appName) {
        this.appName = appName;
    }

    public void update(double stockPrice) {
        System.out.println(appName + " received stock price update: " + stockPrice);
    }
}

class WebStockObserver implements StockObserver {
    private String appName;

    public WebStockObserver(String appName) {
        this.appName = appName;
    }

    public void update(double stockPrice) {
        System.out.println(appName + " received stock price update: " + stockPrice);
    }
}
