package com.example.utils;

import com.example.pages.BasePage;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();
        WebDriver driver = null;

        if (testInstance instanceof BasePage) {
            driver = ((BasePage) testInstance).getDriver();
        }

        if (driver != null) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
            BasePage.test.get().fail("Test Failed: " + result.getName())
                    .addScreenCaptureFromPath(screenshotPath);
        }
    }
}
