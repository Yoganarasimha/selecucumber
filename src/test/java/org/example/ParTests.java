package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.sql.Driver;

public class ParTests {
    protected final Logger logger = LogManager.getLogger(this.getClass());
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    @BeforeMethod
    public void initiate(ITestContext ctx){
        logger.debug("started beforemethod hook");
        driver.set(DriverManager.getDriver());
        ctx.setAttribute("driver", driver.get());
        logger.debug("ended before method hook");
    }

    @AfterClass
    public void teardown(){
        driver.get().quit();
        logger.debug("called driver.quit");
    }

    @Test
    public void method_one(ITestContext ctx){
        logger.info("started method_one");
        HomePage hp = new HomePage((WebDriver) ctx.getAttribute("driver"));
        hp.getHomrPage();
        hp.enterSearchText("love");

        int c = hp.getSearchResCount("love");
        Assert.assertEquals(c,1);
        logger.info("ended method_one");
    }
    @Test
    public void method_two(ITestContext ctx){
        logger.info("started method_two");
        HomePage hp = new HomePage((WebDriver) ctx.getAttribute("driver"));
        hp.getHomrPage();
        hp.enterSearchText("goal");
        int c = hp.getSearchResCount("goal");
        Assert.assertEquals(c,1);
        logger.info("ended method_two");
    }
}
