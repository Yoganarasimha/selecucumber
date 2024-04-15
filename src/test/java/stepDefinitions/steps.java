package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.DriverFactory;
import org.example.DriverManager;
import org.example.HomePage;
import org.example.TestRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;

import java.util.List;


public class steps {
    protected final Logger logger = LogManager.getLogger();
    HomePage hp = new HomePage(DriverManager.getDriver());
    String verifyText;
    @Given("^User starts test$")
    public void startTest(){
        System.out.println("Test started");
    }
/*    @When("^User Enters values {string} and {string}$")
    public void enterValues(String i, String j){
        System.out.println("user entered "+i+"\t"+j);
    }*/
    @Then("^User stops$")
    public void stopTest(){
        System.out.println("test stopped");
    }

    @When("User Enters values {string} and {string}")
    public void userEntersValuesAnd(String arg0, String arg1) {
        System.out.println("entered values: "+arg0+" and "+arg1);
    }

    @Given("User Opens Browser")
    public void userOpensBrowser() {
        hp.getHomrPage();
    }

    @When("User enters {string}")
    public void userEntersString(String text) {
        verifyText = text;
        hp.enterSearchText(text);
    }

    @Then("User sees result")
    public void userSeesResult() {
        int resSize = hp.getSearchResCount(verifyText);
        Assert.assertTrue(resSize>0,"no Valid search results found");
        hp.getDriver().quit();
    }

    @Then("User saw result")
    public void userSawResult() {
        int resSize = hp.getSearchResCount(verifyText);
        Assert.assertEquals(resSize, 0, "no Valid search results found");
        hp.getDriver().quit();
    }
}
