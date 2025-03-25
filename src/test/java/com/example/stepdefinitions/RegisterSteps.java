package com.example.stepdefinitions;

import com.example.pages.HomePage;
import com.example.pages.MyAccountPage;
import com.example.pages.RegisterPage;
import com.example.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class RegisterSteps {
    RegisterPage registerPage = new RegisterPage();
    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();

    @Given("I open the register page")
    public void i_open_the_register_page() {
        homePage.clickCreateAnAccountLink();
        //  DriverManager.getDriver().get("https://magento.softwaretestingboard.com/customer/account/create/");
    }


    @And("I fill up the registration form")
    public void iFillUpTheRegistrationForm() {
        registerPage.fillUpRegistrationForm();
    }

    @And("I click the register button")
    public void iClickTheRegisterButton() {
        registerPage.clickRegisterBtn();
    }

    @Then("I should be registered successfully")
    public void iShouldBeRegisteredSuccessfully() {
        Assert.assertTrue(myAccountPage.isWelcomeTextVisible());
    }
}
