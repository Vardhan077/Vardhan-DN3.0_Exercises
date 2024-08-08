package WEEK1_DSA.DSA;
import java.util.*;



public class SortingCustomerOrders {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getPrice() > orders[j + 1].getPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getPrice() < pivot.getPrice()) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 300),
            new Order(2, "Bob", 150),
            new Order(3, "Charlie", 200)
        };

        System.out.println("Before Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        bubbleSort(orders);

        System.out.println("\nAfter Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        Order[] ordersForQuickSort = {
            new Order(1, "Alice", 300),
            new Order(2, "Bob", 150),
            new Order(3, "Charlie", 200)
        };

        System.out.println("\nBefore Quick Sort:");
        for (Order order : ordersForQuickSort) {
            System.out.println(order);
        }

        quickSort(ordersForQuickSort, 0, ordersForQuickSort.length - 1);

        System.out.println("\nAfter Quick Sort:");
        for (Order order : ordersForQuickSort) {
            System.out.println(order);
        }
    }
}



class Order {
    private int id;
    private String customer;
    private int price;

    Order(int id, String customer, int price) {
        this.id = id;
        this.customer = customer;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return customer + ": $" + price;
    }
}