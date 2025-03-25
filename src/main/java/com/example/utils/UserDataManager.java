package com.example.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 8) return false;

        int classesCount = 0;
        if (password.matches(".*[a-z].*")) classesCount++; // Lowercase
        if (password.matches(".*[A-Z].*")) classesCount++; // Uppercase
        if (password.matches(".*\\d.*")) classesCount++;  // Digits
        if (password.matches(".*[@$!%*?&].*")) classesCount++; // Special characters

        return classesCount >= 3;
    }
}

