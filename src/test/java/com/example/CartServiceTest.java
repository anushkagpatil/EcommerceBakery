//import java.beans.Transient;
package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTest {

    private CartService cartService;

    @BeforeEach
    void setUp() {
        System.out.println("\nSetting up CartService before test...");
        cartService = new CartService();
    }

    @Test
    void testAddNewProductToCart() {
        System.out.println("Running test: Add new product to cart");

        cartService.addToCart(101, 2);
        System.out.println("Added product 101 with quantity 2");

        System.out.println("Checking quantity and cart size...");
        assertEquals(2, cartService.getQuantity(101));
        assertEquals(1, cartService.getCartSize());

        System.out.println("Test passed: New product added successfully.");
    }

    @Test
    void testAddExistingProductIncreasesQuantity() {
        System.out.println("Running test: Add existing product increases quantity");

        cartService.addToCart(101, 2);
        System.out.println("Added product 101 with quantity 2");

        cartService.addToCart(101, 3);
        System.out.println("Added product 101 again with quantity 3");

        System.out.println("Checking if quantity updated to 5...");
        assertEquals(5, cartService.getQuantity(101));

        System.out.println("Test passed: Quantity updated correctly.");
    }

    @Test
    void testAddMultipleProducts() {
        System.out.println("Running test: Add multiple products");

        cartService.addToCart(101, 2);
        System.out.println("Added product 101 with quantity 2");

        cartService.addToCart(102, 1);
        System.out.println("Added product 102 with quantity 1");

        System.out.println("Checking cart size and product quantities...");
        assertEquals(2, cartService.getCartSize());
        assertEquals(1, cartService.getQuantity(102));

        System.out.println("Test passed: Multiple products handled correctly.");
    }

    @Test
    void testAddZeroQuantityThrowsException() {
        System.out.println("Running test: Add zero quantity should throw exception");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cartService.addToCart(101, 0);
        });

        System.out.println("Exception caught: " + exception.getMessage());
        assertEquals("Quantity must be greater than zero", exception.getMessage());

        System.out.println("Test passed: Correct exception thrown for zero quantity.");
    }

    @Test
    void testAddNegativeQuantityThrowsException() {
        System.out.println("Running test: Add negative quantity should throw exception");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cartService.addToCart(101, -3);
        });

        System.out.println("Exception caught: " + exception.getMessage());
        System.out.println("Test passed: Exception thrown for negative quantity.");
    }
}