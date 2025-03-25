package com.example.pages;

import com.example.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
