import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RSystemsInterview {
    public static void main(String[] args) {
        //tablePrinter(5);
        tablePrint(20,6);

    }

    public static void q1(){
        String input = "A#B%C";
        Map<String, List<Integer>> spchars = new HashMap<String,List<Integer>>();
        StringBuilder sb = new StringBuilder();
        for(Character c: input.toCharArray()){
            List<Integer> indices;
            if(!Character.isDigit(c)&&!Character.isAlphabetic(c)){
                if(spchars.containsKey(String.valueOf(c))){
                    indices =spchars.get(String.valueOf(c));
                }else{
                    indices = new ArrayList<>();
                }
                indices.add(input.indexOf(c));
                spchars.put(String.valueOf(c),indices);
            }else{
                sb.append(c);
            }
        }
        sb.reverse();
        for(String k: spchars.keySet()){
            List<Integer> indices = spchars.get(k);
            for(int i: indices){
                sb.insert(i,k);
            }
        }
        System.out.println(sb);
    }

    public static void q2(){
        String xyz = "Chamberlain has a good workCulture";
        String[] words = xyz.split(" ");
        int maxlength = 0;
        for(String word: words){
            if (word.length()>maxlength) maxlength = word.length();
        }
        for(String word: words){
            StringBuilder sb = new StringBuilder(word);
            if (word.length()< maxlength){
                for(int i=0;i<maxlength-word.length();i++){
                    sb.insert(0," ");
                }
            }
            System.out.println(sb);
        }
    }

    public static void irctc(){
        String url = "https://www.irctc.co.in";
        String siteTitle = "IRCTC Next Generation eTicketing System";
        String StationInput = "//p-autocomplete[@id='origin']//descendant::input";
        String StationOption = "//div[contains(@class,'ui-autocomplete-panel')]/ul[@role='listbox']/li[span[contains(text(),'%s')]]"; // send in Upper case
        String OptionsDropdown = "//div[contains(@class,'ui-autocomplete-panel')]";
        String originStation = "Bengaluru";
        String CalendarControl = "//div[contains(@class,'ui-datepicker-calendar-container')]";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
        WebElement origin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StationInput)));
        String inp = originStation.substring(0,3);
        origin.sendKeys(inp);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OptionsDropdown)));
        String searchXpath = String.format(StationOption,originStation.toUpperCase());
        driver.findElement(By.xpath(searchXpath)).click();


        driver.quit();
    }

    public static void q21(){
        String xyz = "Chamberlain has a good workCulture";
        String[] words = xyz.split(" ");
        int maxlength = 0;
        for(String word: words){
            if (word.length()>maxlength) maxlength = word.length();
        }
        for(String word: words){
            String w = (word.length()<maxlength) ? word.indent(maxlength-word.length()) : word;
            System.out.println(w);
        }


    }

    public static void tableOf3(){
        List<Integer> range = new ArrayList<>();
        for(int i=1;i<=10;i++){
            range.add(i);
        }
        range.forEach(i-> System.out.printf("%d x %d = %d%n",i,3,i*3));
    }

    public static void tablePrinter(int n){
        System.out.printf("printing table of %d\n",n);
        List<Integer> range = new ArrayList<>();
        for(int i=1;i<=10;i++){
            range.add(i);
        }
        range.forEach(i-> System.out.printf("%d x %d = %d%n",i,n,i*n));
    }

    public static void tablePrint(int range, int number){
        IntStream.range(1,range+1).forEach(i-> System.out.printf("%d x%d = %d\n",i,number,i*number));
    }


}
