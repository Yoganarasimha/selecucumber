package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.sql.Driver;

public class ParTests {
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    @BeforeMethod
    public void initiate(ITestContext ctx){
        driver.set(DriverManager.getDriver());
        ctx.setAttribute("driver", driver.get());
    }

    @AfterClass
    public void teardown(){
        driver.get().quit();
    }

    @Test
    public void method_one(ITestContext ctx){
        HomePage hp = new HomePage((WebDriver) ctx.getAttribute("driver"));
        hp.getHomrPage();
        hp.enterSearchText("love");

        int c = hp.getSearchResCount("love");
        Assert.assertEquals(c,1);
    }
    @Test
    public void method_two(ITestContext ctx){
        HomePage hp = new HomePage((WebDriver) ctx.getAttribute("driver"));
        hp.getHomrPage();
        hp.enterSearchText("goal");
        int c = hp.getSearchResCount("love");
        Assert.assertEquals(c,1);
    }
}
