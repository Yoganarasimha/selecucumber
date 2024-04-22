package org.example;

import com.sun.jna.Pointer;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage{
    protected static final Logger logger = LogManager.getLogger();
    @FindBy(xpath = "//textarea[@aria-label='Search']")
    WebElement search;

    private String baseUrl = "https://www.google.com";
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void getHomrPage(){
        logger.info("navigating to base url: "+this.baseUrl);
        this.driver.get(this.baseUrl);
    }

    public void enterSearchText(String text){
        logger.info("entering search text "+text);
        search.sendKeys(text);
        search.sendKeys(Keys.ENTER);
    }

    public int getSearchResCount(String text){
        logger.info("searching for text: "+text);
        String xpath = String.format("//div[@id='search']//*[contains(text(),'%s')]",text);
        logger.info("using xpath: "+xpath);
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        List<WebElement> list = driver.findElements(By.id("search"));
        logger.debug("found elements "+list.size());
        Actions actions = new Actions(driver);
        actions.click(search).pause(Duration.ofSeconds(2)).release().build().perform();
        PointerInput pi = new PointerInput(PointerInput.Kind.MOUSE,"default mouse");
        return list.size();
    }

    public WebDriver getDriver(){
        return this.driver;
    }

}
