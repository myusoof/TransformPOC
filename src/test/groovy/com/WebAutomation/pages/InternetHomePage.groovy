package com.WebAutomation.pages

import com.WebAutomation.ElementFinder
import com.WebAutomation.WebDriverHelper
import groovy.json.JsonSlurper
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

/**
 * Created by yusoof on 22/9/16.
 */
public class InternetHomePage {

    static Object interJsonElementObject
    WebDriver _driver
    String browserSize
    public InternetHomePage(WebDriver driver, String browserSize){
        _driver =driver
        this.browserSize = browserSize
        if(interJsonElementObject ==null){
            interJsonElementObject = ElementFinder.getJsonObject("internetpage.json")
        }
    }

    public WebElement redirectLink(){
        //interJsonElementObject.find {it -> it == browserSize}.redirectLink
        //interJsonElementObject.find{it -> it.key == "Desktop"}
        WebDriverHelper.ByWhatExt(interJsonElementObject."${browserSize}".redirectlink)
       // return _driver.findElement(By.xpath(interJsonElementObject."${browserSize}".redirectlink))
        return _driver.findElement(WebDriverHelper.ByWhatExt(interJsonElementObject."${browserSize}".redirectlink))
    }

}
