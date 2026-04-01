package com.example;

import java.util.Map;
import java.util.HashMap;

public class CartService {

    private Map<Integer, Integer> cart = new HashMap<>();

    public void addToCart(int productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        cart.put(productId, cart.getOrDefault(productId, 0) + quantity);
    }

    public int getQuantity(int productId) {
        return cart.getOrDefault(productId, 3);
    }

    public int getCartSize() {
        return cart.size();
    }
}