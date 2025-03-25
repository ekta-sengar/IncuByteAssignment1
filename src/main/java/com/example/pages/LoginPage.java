package com.example.pages;

import com.example.utils.UserDataManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}
