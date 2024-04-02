import java.util.*;

class Product {
    private double price;
    
    public Product(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
}

public class SalesAnalyzer {
    public static void main(String[] args) {
        List<Product> sales = new ArrayList<>();
        // Populate sales list with product sales
        
        // Example sales data
        sales.add(new Product(30.0));
        sales.add(new Product(70.0));
        sales.add(new Product(150.0));
        sales.add(new Product(40.0));
        sales.add(new Product(180.0));
        
        Map<String, Integer> productCountByPriceRange = new HashMap<>();
        Map<String, Double> revenueByPriceRange = new HashMap<>();
        
        // Initialize price ranges
        String[] priceRanges = {"$0-50", "$50-100", "$100-200", "Above $200"};
        for (String range : priceRanges) {
            productCountByPriceRange.put(range, 0);
            revenueByPriceRange.put(range, 0.0);
        }
        
        // Analyze sales data
        for (Product product : sales) {
            double price = product.getPrice();
            if (price <= 50.0) {
                updateData("$0-50", productCountByPriceRange, revenueByPriceRange, price);
            } else if (price <= 100.0) {
                updateData("$50-100", productCountByPriceRange, revenueByPriceRange, price);
            } else if (price <= 200.0) {
                updateData("$100-200", productCountByPriceRange, revenueByPriceRange, price);
            } else {
                updateData("Above $200", productCountByPriceRange, revenueByPriceRange, price);
            }
        }
        
        // Display results
        System.out.println("Number of products sold within specific price ranges:");
        for (String range : priceRanges) {
            System.out.println(range + ": " + productCountByPriceRange.get(range));
        }
        
        System.out.println("\nTotal revenue generated within each price range:");
        for (String range : priceRanges) {
            System.out.println(range + ": $" + revenueByPriceRange.get(range));
        }
    }
    
    private static void updateData(String range, Map<String, Integer> productCountByPriceRange,
                                   Map<String, Double> revenueByPriceRange, double price) {
        productCountByPriceRange.put(range, productCountByPriceRange.get(range) + 1);
        revenueByPriceRange.put(range, revenueByPriceRange.get(range) + price);
    }
}
