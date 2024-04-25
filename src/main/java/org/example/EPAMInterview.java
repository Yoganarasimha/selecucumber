package org.example;

import io.cucumber.java.eo.Do;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.StringJoiner;

public class EPAMInterview {
    public static void main(String[] args) {
        By WebTableLocator = By.xpath("//table[@class='dataTable']");
        By CurrentPriceLocator = By.xpath("//table[@class='dataTable']//tbody//td[4]");
        String cellCurrentPricePath = "//table[@class='dataTable']//tbody//td[4]";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/web-table-element.php");
        wait.until(ExpectedConditions.titleIs("Web Table Elements"));
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(WebTableLocator));
        List<WebElement> currentPrices = table.findElements(CurrentPriceLocator);
        OptionalDouble mavPrice = currentPrices.stream().mapToDouble(e-> Double.parseDouble(e.getText())).max();
        wait.until(new PageLoaded());
        if(mavPrice.isPresent()){
            String addFilter = "[text()='"+mavPrice.getAsDouble()+"']//preceding-sibling::td[a]";
            String companyName = driver.findElement(By.xpath(cellCurrentPricePath+addFilter)).getText();
            System.out.println("Company name with max Current Price is "+companyName);
        }
    }

    public static void question3(){
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        for(int i=0;i<nums.length;i++){
            if(i>0 && i<nums.length-2){
                int prev = nums[i-1];
                int next = nums[i+1];
                if(nums[i]>prev&&nums[i]>next){
                    System.out.println("Number strictly greater than adjacent elements is"+nums[i]);
                }
            }
        }
    }
}
