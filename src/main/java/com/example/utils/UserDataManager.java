package com.example.utils;

import java.util.HashMap;
import java.util.Map;

public class UserDataManager {

    private static Map<String, String> userCredentials = new HashMap<>();
    private static String lastRegisteredEmail;

    // Method to add a new user
    public static void addUser(String email, String password) {
        userCredentials.put(email, password);
        lastRegisteredEmail = email;
    }

    // Method to retrieve password for a given email
    public static String getPassword(String email) {
        return userCredentials.get(email);
    }

    // Method to check if user exists
    public static boolean isUserRegistered(String email) {
        return userCredentials.containsKey(email);
    }

    public static String getLastRegisteredEmail() {
        return lastRegisteredEmail;
    }
}

