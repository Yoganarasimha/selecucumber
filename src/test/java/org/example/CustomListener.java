package org.example;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class CustomListener extends TestListenerAdapter implements ITestListener,IRetryAnalyzer {
    int count = 0;
    final int limit = 3;
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String cwd = System.getProperty("user.dir");
        String name = result.getMethod().getMethodName();
        String sep = File.pathSeparator;
        String filename = name+System.currentTimeMillis()+".png";
        String path = cwd+"\\screenshots\\"+name+System.currentTimeMillis()+".png";
        System.out.println("current dir "+cwd);
        if(ss!=null){
            System.out.println("capture not null");
        }else{
            System.out.println("captue is null");
        }
        try {
            FileUtils.copyFile(ss,createFilePath(filename));
            System.out.println("copied file");
            String msg = "<div> error logs" +
                    "<img src='"+path+
                    "'/></div>";
            Reporter.log(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //byte[] scrshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        //String base64Str = Base64.getEncoder().encodeToString(scrshot);
        //Scenario scenario = (Scenario) Reporter.getCurrentTestResult().getTestContext().getAttribute("scenario");
        //scenario.attach(base64Str,"image/png","Screenshot");
        driver.quit();
    }

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<limit){
            count++;
            return true;
        }
        return false;
    }

    public File createFilePath(String name){
        String opFolder = "screenshots";
        Path cwd = Paths.get(System.getProperty("user.dir"));
        Path opf = cwd.resolve(opFolder);
        if(!opf.toFile().exists()){
            opf.toFile().mkdirs();
        }
        Path filePath = opf.resolve(name);
        return filePath.toFile();
    }


    @BeforeSuite
    public void logSetup(){
        // Configure Log4j programmatically
        System.setProperty("log4j.configuration", "org/apache/logging/log4j/simpleLogger.properties");
        // You can adjust the log level as per your requirements
        System.setProperty("org.apache.logging.log4j.simplelog.level", "DEBUG");
    }
}
