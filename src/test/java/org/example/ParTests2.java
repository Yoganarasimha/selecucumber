package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParTests2 {
    protected final Logger logger = LogManager.getLogger(this.getClass());
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    @BeforeMethod
    public void initiate(ITestContext ctx){
        logger.debug("Started beforeMethod hook execution");
        driver.set(DriverManager.getDriver());
        ctx.setAttribute("driver", driver.get());
        logger.debug("ended before method execution");
    }

    @Test
    public void method_one(ITestContext ctx){
        logger.info("started Method_one test");
        HomePage hp = new HomePage((WebDriver) ctx.getAttribute("driver"));
        hp.getHomrPage();
        hp.enterSearchText("love");
        int c = hp.getSearchResCount("love");
        Assert.assertEquals(c,1);
        logger.info("ended method_one test");
    }
    @Test
    public void method_two(ITestContext ctx){
        logger.info("started method_two test");
        HomePage hp = new HomePage((WebDriver) ctx.getAttribute("driver"));
        hp.getHomrPage();
        hp.enterSearchText("goal");
        int c = hp.getSearchResCount("goal");
        Assert.assertEquals(c,1);
        logger.info("ended method_two test");
    }
}
