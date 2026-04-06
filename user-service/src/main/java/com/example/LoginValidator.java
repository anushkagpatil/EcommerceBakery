package com.example; 


public class LoginValidator {

    public boolean isValidUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        return username.length() >= 5;
    }

    public boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        return password.length() >= 8;
    }

    public boolean login(String username, String password) {
        if (!isValidUsername(username) || !isValidPassword(password)) {
            return false;
        }

        return username.equals("admin") && password.equals("admin123");
    }
}