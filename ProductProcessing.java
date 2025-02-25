import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
}

public class ProductProcessing {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 800),
            new Product("Phone", "Electronics", 600),
            new Product("TV", "Electronics", 1000),
            new Product("Shirt", "Clothing", 40),
            new Product("Jeans", "Clothing", 60),
            new Product("Refrigerator", "Appliances", 500)
        );

        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        groupedByCategory.forEach((category, productList) -> {
            System.out.println("Category: " + category);
            productList.forEach(p -> System.out.println("  " + p.getName() + " - $" + p.getPrice()));
        });

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparing(Product::getPrice))
            ));

        mostExpensiveByCategory.forEach((category, product) -> 
            System.out.println("Most Expensive in " + category + ": " + product.map(Product::getName).orElse("None")));

        double averagePrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0);

        System.out.println("Average Price of all products: $" + averagePrice);
    }
}
