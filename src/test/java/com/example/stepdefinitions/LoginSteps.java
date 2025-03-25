package com.example.stepdefinitions;

import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.example.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.testng.Assert.assertTrue;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("I open the login page")
    public void i_open_the_login_page() {
        homePage.clickSignInLink();
      //  DriverManager.getDriver().get("https://magento.softwaretestingboard.com/customer/account/create/");
    }
    @When("I enter username")
    public void i_enter_username() {
        loginPage.enterUsername();
    }

    @When("I enter password")
    public void i_enter_password() {
        loginPage.enterPassword();
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        // Add assertion here based on successful login
        assertTrue(loginPage.isUserLoggedIn());
    }
}
