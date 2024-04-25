package org.example;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageLoaded implements ExpectedCondition<Boolean> {

    public PageLoaded(){
    }

    @Override
    public Boolean apply(WebDriver driver) {
        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
    }
}
