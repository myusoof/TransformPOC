package com.WebAutomation.steps

import com.RestAutomation.helper.ConfigurationHelper
import com.WebAutomation.WebDriverHelper
import com.WebAutomation.WebDriverHelper
import groovy.transform.Field
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

/**
 * Created by yusoof on 5/9/16.
 */
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

@Field
WebDriver driver = WebDriverHelper.createWebDriverInstance(ConfigurationHelper.driverType)

Then(~'I verify the text in the canvas element'){->
    WebElement element= WebDriverHelper.FindElementsWithJQuery("script:not([src])")[1]
            //((JavascriptExecutor)(driver)).executeScript("""return jQuery("script:not([src])").get(1)""")
    String text = getTextFromCanvasElement(element)
    println text + ""
}

Then (~'I validate the first button click'){->
    driver.findElement(By.xpath("//a[@class='button']")).click()
}
Then (~'I validate the second button click'){->
    driver.findElement(By.xpath("//a[@class='button']")).click()
}
Then(~'I find the edit button in text "(.*)"'){textElement ->
    WebElement element = WebDriverHelper.FindElementsWithJQuery("tbody td:contains('Iuvaret0')\").parent().find(\"a:contains('edit')")
    println element.text
}
Then (~'I validate the third button click'){->
    //driver.findElement(By.xpath("//a[@class='button']")).click()
    driver.findElement(WebDriverHelper.ByWhat("xpath","//a[@class='button']")).click()
    WebElement element1 = new By.ByXPath("//a").findElement(driver)
    println element1
}

private String getTextFromCanvasElement(WebElement element) {
    String textReturn  =((JavascriptExecutor)driver).executeScript("""
        var elementText = arguments[0].innerText;
        return /strokeText\\('Answer: (.*)'/.exec(elementText)[1];
        """,element)
    textReturn
}