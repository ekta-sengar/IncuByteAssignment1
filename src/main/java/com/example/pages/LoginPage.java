package com.example.pages;

import com.example.utils.UserDataManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static com.example.utils.UserDataManager.isValidEmail;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(xpath = "//button/span[contains(text(), 'Sign In')]")
    private WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(), 'Welcome, Test User!')]")
    WebElement welcomeTxt;

    @FindBy(xpath = "//button[@class = 'action switch']")
    WebElement actionArrow;

    @FindBy(xpath = "//a[contains(text(), 'Sign Out')]")
    WebElement signOut;

    @FindBy(xpath = "//div[@for='email']")
    WebElement emailErrMsg;

    @FindBy(xpath = "//div[@for='pass']")
    WebElement passErrMsg;

    @FindBy(xpath = "//div[contains(text(), 'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.')]")
    WebElement invalidCredentialsErr;

    String user;

    public void enterUsername() {
        user = UserDataManager.getLastRegisteredEmail();
        email.sendKeys(user);
    }

    public void enterPassword() {
        String pass = UserDataManager.getPassword(user);
        password.sendKeys(pass);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isUserLoggedIn() {
        return welcomeTxt.isDisplayed();
    }

    public void signOut() {
        actionArrow.click();
        signOut.click();
    }

    public void validateRequiredFieldError() {
        String requiredFieldErrMsg = "This is a required field.";
        clickLogin();
        waitForElementVisibility(emailErrMsg,5);
        Assert.assertEquals(emailErrMsg.getText(), requiredFieldErrMsg);
        Assert.assertEquals(passErrMsg.getText(), requiredFieldErrMsg);
    }

    public void checkLoginFormValidations(List<Map<String, String>> userData) {
        String invalidEmailErr = "Please enter a valid email address (Ex: johndoe@domain.com).";
        for(Map<String, String> user : userData) {
            String emailText  = user.get("Email");
            String passText = user.get("Password");
            email.clear();
            email.sendKeys(emailText);
            password.clear();
            password.sendKeys(passText);
            clickLogin();
            if(!isValidEmail(emailText)) {
                waitForElementVisibility(emailErrMsg, 5);
                Assert.assertEquals(emailErrMsg.getText(),invalidEmailErr);
            }
            else {
                Assert.assertTrue(invalidCredentialsErr.isDisplayed());
            }

        }
    }
}
