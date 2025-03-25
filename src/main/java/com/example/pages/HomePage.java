package com.example.pages;

import com.example.utils.JavaScriptUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[contains(text(), 'Sign In')]")
    private WebElement signInLink;

    @FindBy(xpath = "//div[@class='panel header']/ul/li/a[contains(text(), 'Create an Account')]")
    private WebElement createAnAccountLink;

    public void clickSignInLink() {
        signInLink.click();
    }

    public void clickCreateAnAccountLink() {
        createAnAccountLink.click();
    }

}
