package org.example.practice12.Task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryService {
    private Map<String, List<Product>> products = new HashMap<>();
    private boolean isInventoryOpen = true;

    public void setInventoryOpen(boolean isOpen) {
        isInventoryOpen = isOpen;
    }

    public void addProduct(Product product) {
        if (isInventoryOpen) {
            products.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
    }

    public Product getProductByCategory(String category, double normalPrice) {
        if (!products.containsKey(category) || products.get(category).isEmpty())
            throw new OutOfStockException("Нет товаров данной категории!");
        var productsOfCategory = products.get(category).stream()
                .filter(p -> p.getPrice() <= normalPrice)
                .findAny()
                .orElseThrow(() -> new OutOfStockException(
                "Нет товаров в категории " + category + " дешевле " + normalPrice));;
        products.get(category).remove(productsOfCategory);
        return productsOfCategory;
    }

    public Map<String, List<Product>> getProducts() {
        return products;
    }
}
