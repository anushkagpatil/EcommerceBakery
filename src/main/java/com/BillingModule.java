package com;

import java.util.HashMap;
import java.util.Map;

public class BillingModule {

    private static Map<String, Integer> priceList = new HashMap<>();

    static {
        priceList.put("bread", 40);
        priceList.put("cake", 350);
        priceList.put("cookies", 150);
        priceList.put("muffin", 60);
    }

    public static int calculateTotalBill(Map<String, Integer> cart) {

        if (cart == null || cart.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

        int total = 0;

        for (Map.Entry<String, Integer> item : cart.entrySet()) {

            String name = item.getKey().toLowerCase();
            int quantity = item.getValue();

            if (!priceList.containsKey(name)) {
                throw new IllegalArgumentException("Invalid item: " + name);
            }

            if (quantity <= 0) {
                throw new IllegalArgumentException("Invalid quantity for " + name);
            }

            total += priceList.get(name) * quantity;
        }

        return total;
    }
}