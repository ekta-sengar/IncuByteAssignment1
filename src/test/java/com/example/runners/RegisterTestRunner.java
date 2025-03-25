package com.example.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Register.feature",
        glue = "com/example/stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RegisterTestRunner extends AbstractTestNGCucumberTests {
}