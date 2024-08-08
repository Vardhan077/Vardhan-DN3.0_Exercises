package WEEK1_DSA.DSA;
import java.util.HashMap;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Product product1 = new Product(1, "Product1", 10, 100);
        Product product2 = new Product(2, "Product2", 5, 200);

        inventory.addProduct(product1);
        inventory.addProduct(product2);

        System.out.println("Product1 Name: " + inventory.getInventory().get(1).getName());
        System.out.println("Product2 Quantity: " + inventory.getInventory().get(2).getStock());

        inventory.updateProductName(1, "UpdatedProduct1");
        inventory.updateProductStock(2, 15);

        System.out.println("Updated Product1 Name: " + inventory.getInventory().get(1).getName());
        System.out.println("Updated Product2 Quantity: " + inventory.getInventory().get(2).getStock());
    }
}

class Product {
    private int id;
    private String name;
    private int stock;
    private int cost;

    Product(int id, String name, int stock, int cost) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Inventory {
    private HashMap<Integer, Product> products;

    Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void removeProduct(int productId) {
        products.remove(productId);
    }

    public void updateProductName(int productId, String name) {
        Product product = products.getOrDefault(productId, null);
        if (product != null) {
            product.setName(name);
        }
    }

    public void updateProductStock(int productId, int stock) {
        Product product = products.getOrDefault(productId, null);
        if (product != null) {
            product.setStock(stock);
        }
    }

    public HashMap<Integer, Product> getInventory() {
        return products;
    }
}
