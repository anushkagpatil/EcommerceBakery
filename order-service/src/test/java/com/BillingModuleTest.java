package com;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class BillingModuleTest {

    Map<String, Integer> cart;

    @Before
    public void setUp() {
        cart = new HashMap<>();
        System.out.println("Starting Test");
    }

    @After
    public void tearDown() {
        cart.clear();
        System.out.println("Test Finished");
    }

    @Test
    public void testSingleItem() {
        cart.put("bread", 2);

        int result = BillingModule.calculateTotalBill(cart);

        assertEquals(80, result);
    }

    @Test
    public void testMultipleItems() {
        cart.put("bread", 2);
        cart.put("cake", 1);
        cart.put("cookies", 3);

        int result = BillingModule.calculateTotalBill(cart);

        assertEquals(880, result);
    }

    @Test
    public void testLargeOrder() {
        cart.put("bread", 10);
        cart.put("muffin", 5);

        int result = BillingModule.calculateTotalBill(cart);

        assertEquals(700, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidItem() {
        cart.put("pizza", 2);
        BillingModule.calculateTotalBill(cart);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroQuantity() {
        cart.put("bread", 0);
        BillingModule.calculateTotalBill(cart);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeQuantity() {
        cart.put("cake", -1);
        BillingModule.calculateTotalBill(cart);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyCart() {
        BillingModule.calculateTotalBill(cart);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullCart() {
        BillingModule.calculateTotalBill(null);
    }
}