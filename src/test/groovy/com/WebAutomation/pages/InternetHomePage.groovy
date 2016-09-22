package com.WebAutomation.pages

import com.WebAutomation.ElementFinder
import groovy.json.JsonSlurper
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

/**
 * Created by yusoof on 22/9/16.
 */
public class InternetHomePage {

    Object interJsonElementObject
    WebDriver _driver
    public InternetHomePage(WebDriver driver){
        _driver =driver
        interJsonElementObject = ElementFinder.loadJsonFile(new File(this.getClass().getResource("/jsonfiles/internetpage.json").path))
    }

    public WebElement redrectLink(){
        return _driver.findElement(By.xpath(interJsonElementObject.Desktop.redirectlink))
    }

}
