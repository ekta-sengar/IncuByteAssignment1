package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    @FindBy(xpath = "//div[contains(text(), 'Thank you for registering with Main Website Store.')]")
    WebElement welcomeText;

    public boolean isWelcomeTextVisible() {
        return welcomeText.isDisplayed();
    }
}
