package com.example.stepdefinitions;

import com.example.pages.LoginPage;
import com.example.utils.UserDataManager;
import io.cucumber.java.Before;

public class Hooks {

    LoginPage loginPage = new LoginPage();

    @Before("@login") // This will run before any scenario tagged with @login
    public void ensureUserIsRegistered() {
        if (UserDataManager.getLastRegisteredEmail() == null) {
            System.out.println("No registered user found! Please run registration first.");
            throw new RuntimeException("Registration scenario must run before login.");
        }
    }

    @Before("@login")
    public void checkUserIsNotLoggedInAlready() {
        if(loginPage.isUserLoggedIn()) {
            loginPage.signOut();
        }
    }
}

