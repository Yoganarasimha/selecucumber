package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParTests2 {
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    @BeforeMethod
    public void initiate(ITestContext ctx){
        driver.set(DriverManager.getDriver());
        ctx.setAttribute("driver", driver.get());
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
        int c = hp.getSearchResCount("goal");
        Assert.assertEquals(c,1);
    }
}
