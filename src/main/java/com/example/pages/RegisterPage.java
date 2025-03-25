package com.example.pages;

import com.example.utils.UserDataManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.example.utils.UserDataManager.isValidEmail;
import static com.example.utils.UserDataManager.isValidPassword;

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

    @FindBy(xpath = "//div[@for='firstname']")
    WebElement firstNameErrorMsg;

    @FindBy(xpath = "//div[@for='lastname']")
    WebElement lastNameErrorMsg;

    @FindBy(xpath = "//div[@for='email_address']")
    WebElement emailErrorMsg;

    @FindBy(xpath = "//div[@for='password']")
    WebElement passwordErrorMsg;

    @FindBy(xpath = "//div[@for='password-confirmation']")
    WebElement passwordConfirmationErrorMsg;

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



    public void checkRegistrationValidations(List<Map<String, String>> userData) {
        for(Map<String, String> user : userData) {
            String firstName  = user.get("First Name");
            String lastName = user.get("Last Name");
            String email = user.get("Email");
            String password1 = user.get("Password");
            String password2 = user.get("Password Confirmation");
            String invalidEmailErrorMessage = "Please enter a valid email address (Ex: johndoe@domain.com).";
            String invalidPasswordLengthErrorMessage = "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.";
            String invalidPasswordErrorMessage = "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.";
            String passwordMatchErrorMessage = "Please enter the same value again.";
            firstname.clear();
            lastname.clear();
            email_address.clear();
            password.clear();
            password_confirmation.clear();
            firstname.sendKeys(firstName);
            lastname.sendKeys(lastName);
            email_address.sendKeys(email);
            password.sendKeys(password1);
            password_confirmation.sendKeys(password2);
            clickRegisterBtn();
            if(isValidEmail(email)) {
                waitForElementVisibility(emailErrorMsg, 5);
                Assert.assertEquals(emailErrorMsg.getText(),invalidEmailErrorMessage);
            }
            if(!password1.equals(password2)) {
                waitForElementVisibility(passwordConfirmationErrorMsg, 5);
                Assert.assertEquals(passwordConfirmationErrorMsg.getText(),passwordMatchErrorMessage);
            }
            if(password1.length()<8) {
                waitForElementVisibility(passwordErrorMsg, 5);
                Assert.assertEquals(passwordErrorMsg.getText(), invalidPasswordLengthErrorMessage);
            }
            else if(!isValidPassword(password1)) {
                waitForElementVisibility(passwordErrorMsg, 5);
                Assert.assertEquals(passwordErrorMsg.getText(), invalidPasswordErrorMessage);
            }
        }
    }

    public void requiredFieldValidation() {
        String requiredFieldErrorMessage = "This is a required field.";
        waitForElementVisibility(firstNameErrorMsg, 5);
            Assert.assertEquals(firstNameErrorMsg.getText(),requiredFieldErrorMessage);
            Assert.assertEquals(lastNameErrorMsg.getText(),requiredFieldErrorMessage);
            Assert.assertEquals(emailErrorMsg.getText(),requiredFieldErrorMessage);
            Assert.assertEquals(passwordErrorMsg.getText(),requiredFieldErrorMessage);
            Assert.assertEquals(passwordConfirmationErrorMsg.getText(),requiredFieldErrorMessage);
    }
}
