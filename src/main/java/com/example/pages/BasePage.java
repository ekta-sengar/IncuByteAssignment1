package com.example.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.utils.DriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

@Getter
public class BasePage {
    protected WebDriver driver;
    protected static ExtentReports extent;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void waitForElementVisibility(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @BeforeSuite
    public void setupExtentReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @BeforeMethod
    public void createTest(Method method) {
        ExtentTest extentTest = extent.createTest(method.getName());
        test.set(extentTest); // Set ExtentTest for the current thread
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            extent.flush();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

}
