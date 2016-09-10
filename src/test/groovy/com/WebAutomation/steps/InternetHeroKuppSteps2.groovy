package com.WebAutomation.steps

import com.RestAutomation.helper.ConfigurationHelper
import com.WebAutomation.MailVerifier
import com.WebAutomation.WebDriverHelper
import com.WebAutomation.WebDriverHelper
import groovy.transform.Field
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

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

Then(~'I upload the file via text'){->
    WebElement element = driver.findElement(By.xpath("//*[@id='file-upload']"))
    element.sendKeys("/home/yusoof/Downloads/Read Me.txt")
    element = driver.findElement(By.xpath("//*[@id='file-submit']"))
    element.click()
}

Then(~'I would test the floating menu'){->
    WebElement element = driver.findElement(By.xpath("//a[text()='Home']"))
    element.click()
    element = driver.findElement(By.xpath("//a[text()='News']"))
    element.click()
    element = driver.findElement(By.xpath("//a[text()='Contact']"))
    element.click()
    element = driver.findElement(By.xpath("//a[text()='About']"))
    element.click()
}

Then(~'I woud like to retrieve forgot password'){->
    WebElement emailField = driver.findElement(By.id("email"))
    emailField.sendKeys(ConfigurationHelper.emailAddress)
    WebElement forgotPassword = driver.findElement(By.id("form_submit"))
    forgotPassword.click()
    WebElement element = driver.findElement(By.id("content"))
    new WebDriverWait(driver,15).until(ExpectedConditions.textToBePresentInElement(element,"Your e-mail's been sent!"))
    MailVerifier mailVerifier = new MailVerifier(ConfigurationHelper.mailServer,ConfigurationHelper.emailAddress, ConfigurationHelper.emailPassword)
    mailVerifier.isMailFound("Forgot Password from the-internet")
    String retrievalLink = mailVerifier.retrievalLink
    driver.navigate().to(retrievalLink)
    driver.findElement(By.id("email")).sendKeys(ConfigurationHelper.emailAddress)
    driver.findElement(By.id("form_submit")).click()
    element = driver.findElement(By.id("content"))
    new WebDriverWait(driver,25).until(ExpectedConditions.textToBePresentInElement(element,"Your e-mail's been sent!"))
}

private String getTextFromCanvasElement(WebElement element) {
    String textReturn  =((JavascriptExecutor)driver).executeScript("""
        var elementText = arguments[0].innerText;
        return /strokeText\\('Answer: (.*)'/.exec(elementText)[1];
        """,element)
    textReturn
}