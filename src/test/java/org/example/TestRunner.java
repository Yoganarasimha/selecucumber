package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@CucumberOptions(
        glue = {"stepDefinitions","MyHooks"},
        features = "./features/webtest.feature",
        plugin = {"pretty","html:target/cucumber-reports","json:target/cucumber.json","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void setup(){
        System.out.println("started");}

    @Override
    @DataProvider()
    public Object[][] scenarios(){
        return super.scenarios();
    }
    @AfterClass
    public void teardown(){
        System.out.println("ended");
    }
}
