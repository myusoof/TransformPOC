package com.WebAutomation.steps

import com.RestAutomation.helper.ConfigurationHelper
import com.RestAutomation.helper.RestClient
import com.WebAutomation.MailVerifier
import com.WebAutomation.WebDriverHelper
import com.WebAutomation.WebDriverHelper
import groovy.transform.Field
import org.apache.http.HttpResponse
import org.openqa.selenium.Alert
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
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

@Field
RestClient client = RestClient.getRestInstance()

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
    WebDriverHelper.WaitInstance(15).until(ExpectedConditions.textToBePresentInElement(element,"Your e-mail's been sent!"))
    MailVerifier mailVerifier = new MailVerifier(ConfigurationHelper.mailServer,ConfigurationHelper.emailAddress, ConfigurationHelper.emailPassword)
    mailVerifier.isMailFound("Forgot Password from the-internet")
    String retrievalLink = mailVerifier.retrievalLink
    driver.navigate().to(retrievalLink)
    driver.findElement(By.id("email")).sendKeys(ConfigurationHelper.emailAddress)
    driver.findElement(By.id("form_submit")).click()
    element = driver.findElement(By.id("content"))
    WebDriverHelper.WaitInstance(25).until(ExpectedConditions.textToBePresentInElement(element,"Your e-mail's been sent!"))
}

Then(~'I enter the username and password'){->
    def usernameElement = driver.findElement(By.id("username"))
    def passwordElement = driver.findElement(By.id("password"))
    def loginElement = driver.findElement(By.className("radius"))
    usernameElement.sendKeys("tomsmith")
    passwordElement.sendKeys("SuperSecretPassword!")
    loginElement.click()
    WebDriverHelper.WaitInstance(15).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("flash"))))
    def logoutButton = driver.findElement(By.xpath("//*[@id='content']//a"))
    logoutButton.click()
}
//Then(~'I click on "(.*)"'){ linkName->
//    driver.findElement(By.xpath("//a[contains(.,'${linkName}')]")).click()
//}
Then(~'I switch to the frame "(.*)"'){ frameName->
    driver.switchTo().frame(frameName)
}
Then(~'I assert the text is "(.*)"'){text->
    assert driver.findElement(By.xpath("//body")).text, text
}

Then(~'back to default frame'){->
    driver.switchTo().defaultContent()
}
Then(~'get the content in the frame'){->
    assert driver.findElement(By.xpath("//body")).text, "Your content goes here."
}

Then(~'set the content "(.*)" in the frameid "(.*)"'){ content, frameid->
    //WebDriverHelper.waitForJQuery()
    String jQuery = "\$('#${frameid}').contents().find('p').html('${content}')"
    WebElement element = driver.findElement(By.xpath("//iframe"))
    //WebDriverHelper.JavaScripExecutor().executeScript("arguments[0].contentWindow.document.body.innerHTML= 'test'",element)
    WebDriverHelper.JavaScripExecutor().executeScript(jQuery)
}

Then(~'I perform the slider action'){ ->
    WebElement element = driver.findElement(By.xpath("//*[@id='content']/div/div/input"))
    WebDriverHelper.GetAction().dragAndDropBy(element,5, 0).build().perform()
    WebDriverHelper.GetAction().dragAndDropBy(element,2, 0).build().perform()
    //dragAndDropByPercentage(element,166)
}

Then(~'I press the space to scroll down'){ ->
    //scroll down
    5.times {
        Thread.sleep(5000)
        WebDriverHelper.JavaScripExecutor().executeScript("setTimeout(scrollBy(0,2500),5000)")
    }
    //scroll up
    5.times {
        WebDriverHelper.JavaScripExecutor().executeScript("setTimeout(scrollBy(0,-2500),5000)")
    }
}
Then(~'I work with jquery menu'){ ->
    WebDriverHelper.GetAction().moveToElement(driver.findElement(By.xpath("//a[text()='Enabled']"))).build().perform()
    WebDriverHelper.GetAction().moveToElement(driver.findElement(By.xpath("//a[text()='Downloads']"))).build().perform()
    WebDriverHelper.GetAction().moveToElement(driver.findElement(By.xpath("//a[text()='PDF']"))).build().perform()
    String pdfUrl = driver.findElement(By.xpath("//a[text()='PDF']")).getAttribute("href")

    HttpResponse response = client.get(uri: pdfUrl)
    assert response.responseData.buf.size() > 0
}

Then(~'I click on button with text "(.*)"'){text ->
    driver.findElement(By.xpath("//button[text()='${text}']")).click()
}

Then(~'I would like to play with js alerts'){->
    Alert alert = driver.switchTo().alert()
    println alert.text
    alert.accept()
}

Then(~'I would like to play with js confirmation accept'){->
    Alert alert = driver.switchTo().alert()
    println alert.text
    alert.accept()
}

Then(~'I would like to play with js confirmation dismiss'){->
    Alert alert = driver.switchTo().alert()
    println alert.text
    alert.dismiss()
}
Then(~'I would like to play with js prompt accept'){->
    Alert alert = driver.switchTo().alert()
    alert.sendKeys("yusoof")
    alert.accept()
}

Then(~'I verify the text in the page "(.*)"'){text ->
    assert driver.getPageSource().toString().contains(text)
}

private void dragAndDropByPercentage(WebElement element, int percentage){

    WebDriverHelper.GetAction().dragAndDropBy(element,((10*percentage)/100).toInteger(), 0).build().perform()
}


private String getTextFromCanvasElement(WebElement element) {
    String textReturn  =((JavascriptExecutor)driver).executeScript("""
        var elementText = arguments[0].innerText;
        return /strokeText\\('Answer: (.*)'/.exec(elementText)[1];
        """,element)
    textReturn
}