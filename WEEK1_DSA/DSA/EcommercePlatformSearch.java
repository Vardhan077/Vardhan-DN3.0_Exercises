package WEEK1_DSA.DSA;
import java.util.*;





public class EcommercePlatformSearch {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Product p1 = new Product(1, "Product1", "Category1");
        Product p2 = new Product(2, "Product2", "Category2");

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        Product result = inventory.findProductLinear(1);
        if (result != null) {
            System.out.println("Linear search found: " + result.name);
        } else {
            System.out.println("Linear search did not find the product.");
        }

        result = inventory.findProductBinary(2);
        if (result != null) {
            System.out.println("Binary search found: " + result.name);
        } else {
            System.out.println("Binary search did not find the product.");
        }
    }
}


class Product {
    int id;
    String name;
    String category;
    int stock;
    int cost;

    Product(int productId, String productName, String category) {
        this.id = productId;
        this.name = productName;
        this.category = category;
    }
}



class Inventory {
    ArrayList<Product> productList;

    Inventory() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product findProductLinear(int productId) {
        for (Product product : productList) {
            if (product.id == productId) {
                return product;
            }
        }
        return null;
    }

    public Product findProductBinary(int productId) {
        Collections.sort(productList, Comparator.comparingInt(x -> x.id));
        int low = 0;
        int high = productList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (productList.get(mid).id == productId) {
                return productList.get(mid);
            } else if (productList.get(mid).id > productId) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }
}