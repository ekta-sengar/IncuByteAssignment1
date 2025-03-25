package com.example.stepdefinitions;

import com.example.pages.HomePage;
import com.example.pages.MyAccountPage;
import com.example.pages.RegisterPage;
import com.example.utils.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

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

    @And("I validate the registration form fields")
    public void iValidateTheRegistrationFormFields(DataTable data) {
        List<Map<String, String>> userData = data.asMaps();
        registerPage.checkRegistrationValidations(userData);
    }

    @Then("I validate required field validation for all fields")
    public void iValidateRequiredFieldValidationForAllFields() {
        registerPage.clickRegisterBtn();
        registerPage.requiredFieldValidation();
    }
}
