package com.example.stepdefinitions;

import com.example.pages.HomePage;
import com.example.utils.DriverManager;
import io.cucumber.java.en.Given;

public class HomeSteps {
    HomePage homePage = new HomePage();
    @Given("I am on home page")
    public void i_am_on_home_page() {
        DriverManager.getDriver().get("https://magento.softwaretestingboard.com/");
    }
}
