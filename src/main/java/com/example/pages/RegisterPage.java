package com.example.pages;

import com.example.utils.UserDataManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;

public class RegisterPage extends BasePage {
    @FindBy(id = "firstname")
    WebElement firstname;

    @FindBy(id = "lastname")
    WebElement lastname;

    @FindBy(id = "email_address")
    WebElement email_address;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "password-confirmation")
    WebElement password_confirmation;

    @FindBy(xpath = "//button/span[contains(text(), 'Create an Account')]")
    WebElement createAnAccountBtn;

    public static String generateRandomEmail(String firstname, String lastname) {
        String randomString = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
        return firstname + lastname + randomString + "@example.com";
    }

    public void fillUpRegistrationForm() {
        String firstName  = "Test";
        String lastName = "User";
        String email = generateRandomEmail(firstName,lastName);
        String password1 = "Welcome@123";
        firstname.sendKeys(firstName);
        lastname.sendKeys(lastName);
        email_address.sendKeys(email);
        password.sendKeys(password1);
        password_confirmation.sendKeys(password1);
        UserDataManager.addUser(email, password1);
    }

    public void clickRegisterBtn() {
        createAnAccountBtn.click();
    }




}
