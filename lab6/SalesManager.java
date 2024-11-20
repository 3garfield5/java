package lab6;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class SalesManager {
    private TreeSet<Product> sales;
    private Map<String, Integer> productCountMap;

    public SalesManager() {
        sales = new TreeSet<>();
        productCountMap = new HashMap<>();
    }

    public void addSale(String name, double price, int quantity) {
        Product newProduct = new Product(name, price, quantity);

        // Если товар с таким именем уже существует, обновляем его количество
        for (Product product : sales) {
            if (product.getName().equals(name)) {
                product.addQuantity(quantity);
                updateProductCount(name, quantity);
                return;
            }
        }

        // Если товар новый, добавляем его в коллекцию
        sales.add(newProduct);
        updateProductCount(name, quantity);
    }

    private void updateProductCount(String name, int quantity) {
        productCountMap.put(name, productCountMap.getOrDefault(name, 0) + quantity);
    }

    public void showSales() {
        System.out.println("Список проданных товаров:");
        for (Product product : sales) {
            System.out.println(product);
        }
    }

    public double calculateTotalSales() {
        double total = 0.0;
        for (Product product : sales) {
            total += product.getTotalPrice();
        }
        return total;
    }

    public String getMostPopularProduct() {
        String popularProduct = null;
        int maxQuantity = 0;

        for (Map.Entry<String, Integer> entry : productCountMap.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                maxQuantity = entry.getValue();
                popularProduct = entry.getKey();
            }
        }

        return popularProduct;
    }
}
