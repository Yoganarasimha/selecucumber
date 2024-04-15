package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
@Listeners(CustomListener.class)
public class AppTest{

    @Test(retryAnalyzer = CustomListener.class)
    public void test1(ITestContext context){
        WebDriver driver = DriverManager.getDriver();
        context.setAttribute("driver",driver);
        HomePage hp = new HomePage(driver);
        hp.getHomrPage();
        hp.enterSearchText("hello");
        Assert.assertTrue(false);
    }

    @Test
    public void test2(ITestContext context){
        WebDriver driver = DriverManager.getDriver();
        context.setAttribute("driver",driver);
        HomePage hp = new HomePage(driver);
        hp.getHomrPage();
        hp.enterSearchText("hello");
        Assert.assertTrue(true);
    }

    public static void main(String[] args) {
        HomePage hp = new HomePage(DriverManager.getDriver());
        hp.getHomrPage();
        hp.enterSearchText("cucumber");
        int cnt = hp.getSearchResCount("cucumber");
        System.out.println(cnt);
    }

}
