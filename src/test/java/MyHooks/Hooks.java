
package MyHooks;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.BasePage;
import org.example.DriverFactory;
import org.example.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.util.Base64;

public class Hooks{
    protected final Logger logger = LogManager.getLogger();

    @Before
    public void setup(ITestContext context){
        logger.info("setting up driver");
        WebDriver driver = DriverFactory.getDriver();
        context.setAttribute("driver",driver);
    }
    @After
    public void afterAction(Scenario scenario, ITestResult result){
        logger.info("executing cucumber hook method after scenario");
        if(scenario.isFailed()){
            WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
            final byte[] scrshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            String encodedImage = Base64.getEncoder().encodeToString(scrshot);
            //logger.info(encodedImage);
            scenario.attach(scrshot,"image/png","Screenshot");
            driver.quit();
        }
    }

}

