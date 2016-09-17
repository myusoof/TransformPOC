package com.WebAutomation

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions

import javax.annotation.Nullable

/**
 * Created by yusoof on 17/9/16.
 */
public class ExpectedConditionsExt extends ExpectedConditions{

    private ExpectedConditionsExt() {
        super()
    }

    public static ExpectedCondition<Boolean> waitForPageToLoad(){
        new ExpectedCondition<Boolean>() {
            @Override
            Boolean apply(@Nullable WebDriver d) {
                return ((JavascriptExecutor)d).executeScript("return document.readyState").equals("complete")
            }
        }
    }

    public static ExpectedCondition<Boolean> waitForTheStatusOfResource( String resourceName ) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                //https://the-internet.herokuapp.com/slow_external
                return BrowserMobHelper.getHar().log.entries.find{it-> it.request.url == resourceName}.response.status != 0
            }
            @Override
            public String toString() {
                return "status found";
            }
        };
    }
}
