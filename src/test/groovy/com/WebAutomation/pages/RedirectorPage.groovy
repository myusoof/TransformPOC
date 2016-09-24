package com.WebAutomation.pages

import com.WebAutomation.ElementFinder
import com.WebAutomation.WebDriverHelper
import org.openqa.selenium.WebDriver

/**
 * Created by yusoof on 22/9/16.
 */
public class RedirectorPage {

    static Object redirectJsonElementObject
    WebDriver _driver
    String browserSize

    public RedirectorPage(WebDriver driver, String browserSize){
        _driver =driver
        this.browserSize = browserSize
        if(redirectJsonElementObject == null){
            redirectJsonElementObject = ElementFinder.getJsonObject("redirectpage.json")
        }
    }

    public hereLink(){
        _driver.findElement(WebDriverHelper.ByWhatExt(redirectJsonElementObject."${browserSize}".here))
    }
}
