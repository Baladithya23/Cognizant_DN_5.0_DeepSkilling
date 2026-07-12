import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    // Linear Search
    public static Product linearSearch(Product[] products, int id) {

        for (Product product : products) {
            if (product.getProductId() == id) {
                return product;
            }
        }

        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int id) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (products[mid].getProductId() == id) {
                return products[mid];
            }

            if (products[mid].getProductId() < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(104, "Laptop", "Electronics"),
                new Product(101, "Mobile", "Electronics"),
                new Product(105, "Shoes", "Fashion"),
                new Product(102, "Watch", "Accessories"),
                new Product(103, "Bag", "Fashion")
        };

        System.out.println("Linear Search Result:");
        Product result1 = linearSearch(products, 102);

        if (result1 != null) {
            System.out.println(result1);
        } else {
            System.out.println("Product not found");
        }

        Arrays.sort(products,
                Comparator.comparingInt(Product::getProductId));

        System.out.println("\nBinary Search Result:");
        Product result2 = binarySearch(products, 102);

        if (result2 != null) {
            System.out.println(result2);
        } else {
            System.out.println("Product not found");
        }
    }
}