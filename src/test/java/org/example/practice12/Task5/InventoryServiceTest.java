package org.example.practice12.Task5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {
    private InventoryService service;
    private Product apple;

    @BeforeEach
    public void setup() {
        service = new InventoryService();
        apple = new Product("Apple", 70, "Fruits");
    }

    @Test
    public void shouldAddProductWithOpenInventory() {
        var initialSize = service.getProducts().size();
        service.addProduct(apple);
        assertEquals(initialSize + 1, service.getProducts().size());
    }

    @Test
    public void shouldNotAddProductWithCloseInventory() {
        service.setInventoryOpen(false);
        var initialSize = service.getProducts().size();
        service.addProduct(apple);
        assertEquals(initialSize, service.getProducts().size());
    }

    @Test
    public void shouldGetExistingCategory() {
        service.addProduct(apple);
        Product expensiveApple = new Product("Apple", 200, "Fruits");
        Product cucumber = new Product("Cucumber", 50.5, "Vegetables");
        service.addProduct(expensiveApple);
        service.addProduct(cucumber);

        var suitableProduct = service.getProductByCategory("Fruits", 100);
        assertEquals(apple, suitableProduct);
    }

    @Test
    public void shouldThrowExceptionWhenProductSoldOut() {
        service.addProduct(apple);
        service.getProductByCategory("Fruits", 100);
        assertThrows(OutOfStockException.class,
                () -> service.getProductByCategory("Fruits", 100));
    }

    @Test
    public void shouldThrowExceptionForNonExistingCategory() {
        service.addProduct(apple);
        assertThrows(OutOfStockException.class,
                () -> service.getProductByCategory("Vegetables", 100));
    }


}