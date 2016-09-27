package com.WindowAutomation.steps

import com.WebAutomation.WebDriverHelper
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.winium.WiniumDriver

/**
 * Created by mohmedyusoof.as on 9/27/2016.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


WiniumDriver driver

Given(~/^I have to launch the window application$/) { ->
    driver = (WiniumDriver)WebDriverHelper.createWebDriverInstance("winium")
    WebElement notepadWindow = driver.findElementByClassName("Notepad")
    notepadWindow.findElement(By.id("9616"))
}