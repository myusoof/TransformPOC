package com.WebAutomation.steps

import com.RestAutomation.helper.ConfigurationHelper
import com.RestAutomation.helper.RestClient
import com.WebAutomation.DialogHelper
import com.WebAutomation.WebDriverHelper
import cucumber.api.DataTable
import groovy.transform.Field
import groovyx.net.http.RESTClient
import junit.framework.Assert
import org.junit.After
import org.openqa.selenium.Alert
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.security.UserAndPassword
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait

import javax.swing.Action
import java.awt.Robot
import java.awt.event.InputEvent


/**
 * Created by yusoof on 3/9/16.
 */
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

@Field
WebDriver driver = WebDriverHelper.createWebDriverInstance(ConfigurationHelper.driverType)

@Field
RestClient client = RestClient.getRestInstance()
Robot robot = new Robot()

Given(~'I navigate to the test application'){ ->
    driver.navigate().to(ConfigurationHelper.webAppliationBaseUrl)
}

Then(~'I click on "(.*)" link'){ linkName ->
    driver.findElement(By.xpath("//a[text()='$linkName']")).click()
}
Then(~'I click on Basic Auth link'){ ->
    //WebElement element = driver.findElement(By.xpath("//a[text()='Basic Auth']")).click()
    driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth")
    //new Thread(new DialogHelper()).start()
//    Alert alert = driver.switchTo().alert();
//    alert.authenticateUsing(new UserAndPassword("admin","admin"))
//    alert.accept()
}
And(~'I validate the page Url "(.*)"'){ url->
    assert driver.getCurrentUrl().contains(url)
}
And(~'I validate the content in the page'){table->
    driver.getPageSource().contains(table.raw().get(0))
}

And(~'I validate the images are loaded correctly'){->
    List<WebElement> elements = driver.findElements(By.xpath("//div[@class='example']/img"))
    elements.each { it ->
        String imgPath = it.getAttribute("src")
        Assert.assertEquals(client.get(path: imgPath).statusLine.statusCode, 200)
    }
}

Then(~'I get validate the status of the checkbox'){->
    List<WebElement> elements = driver.findElements(WebDriverHelper.ByWhat("xpath","//.[@id='checkboxes']/input"))
    List<WebElement> elementsWithJqery = WebDriverHelper.FindElementsWithJQuery("form input:not(:checked)")
    elementsWithJqery.each {it->if(!it.isSelected()){
        it.click()
    } }
//    elements.each{ element ->
//          if(!element.isSelected()){
//              element.click()
//          }
    //}
}
Then(~'I validate the context menu'){->
    WebElement contextBox = driver.findElement(By.xpath("//*[@id='hot-spot']"))
    Actions actions = new Actions(driver)
    actions.contextClick(contextBox)
            .sendKeys(Keys.ARROW_DOWN)
            .sendKeys(Keys.ARROW_DOWN)
            .sendKeys(Keys.ARROW_DOWN)
            .sendKeys(Keys.ARROW_DOWN)
            .sendKeys(Keys.RETURN).build().perform()
    //Thread.sleep(5000)
//    actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform()
//    Thread.sleep(5000)
    Alert alert = driver.switchTo().alert()
    println alert.text == "You selected a context menu"
    alert.accept()
}
List<String> elementText = new ArrayList<String>();
Then(~'I get all the menus which appears'){->
    try{
        5.times {
            if(driver.findElements(By.xpath("//li")).size()==5){
                throw new Exception()
            }else{
                driver.navigate().refresh()
            }
        }
    }catch (Exception e){
        println "element found"
    }
    driver.findElement(By.xpath("//li/a[text()=='Home']")).click()
}

Then(~'I perform drag and drop operation'){->
    WebElement sourceElement = driver.findElement(By.xpath("//*[@id='column-a']"))
    WebElement targetElement = driver.findElement(By.xpath("//*[@id='column-b']"))
    Actions actions = new Actions(driver)
    actions.moveToElement(sourceElement).clickAndHold().build().perform()
    Locatable locate = (Locatable)targetElement

    def getXPositionOfLocatable = locate.coordinates.onPage().x
    def getYPositionOfLocatable = locate.coordinates.onPage().y

    def getLeftPositionOfWindow = driver.manage().window().getPosition().x
    def getTopPositionOfWindow = driver.manage().window().getPosition().y
    def xPosition = getLeftPositionOfWindow+getXPositionOfLocatable
    def yPosition = getYPositionOfLocatable+getTopPositionOfWindow
    robot.mouseMove(xPosition,yPosition+80 )
    Thread.sleep(2000)
    robot.mousePress(InputEvent.BUTTON1_MASK)
    robot.mouseRelease(InputEvent.BUTTON1_MASK)
    assert targetElement.text, "A"
}

Then(~'I have to select the option'){->
    WebElement element = driver.findElement(By.xpath("//*[@id='dropdown']"))
    Select select = new Select(element)
    select.selectByIndex(2)
    select.selectByValue("1")
    select.selectByVisibleText("Option 2")
    println select.isMultiple()
}
Then(~'I have to play with dynamic controls'){->
    WebElement element = driver.findElement(By.xpath("//button[text()='Remove']"))
    element.click()
    new WebDriverWait(driver,15000).until(ExpectedConditions.textToBePresentInElement(element,"Add"))
     element = driver.findElement(By.xpath("//button[text()='Add']"))
    element.click()
    new WebDriverWait(driver,15000).until(ExpectedConditions.textToBePresentInElement(element,"Remove"))

}
Then(~'I have to play with wait for element'){->
    WebElement element = driver.findElement(By.xpath("//button[text()='Remove']"))
    element.click()
    new WebDriverWait(driver,15000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//input[@id='checkbox']")))
    element = driver.findElement(By.xpath("//button[text()='Add']"))
    element.click()
}
Then(~'I click on first link'){->
    WebElement firstElement = driver.findElement(By.xpath("//div[@class='example']/a[1]"))
    firstElement.click()
}
Then(~'Click on start button in the first page'){->
    WebElement element = driver.findElement(By.xpath("//*[@id='start']/button"))
    element.click()
    new WebDriverWait(driver,15000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']")))
    println driver.findElement(By.xpath("//*[@id='finish']")).text
    driver.navigate().back()
}

Then(~'I click on second link'){->
    WebElement firstElement = driver.findElement(By.xpath("//div[@class='example']/a[2]"))
    firstElement.click()
}
Then(~'Click on start button in the second page'){->
    WebElement element = driver.findElement(By.xpath("//*[@id='start']/button"))
    element.click()
    new WebDriverWait(driver,15000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']")))
    println driver.findElement(By.xpath("//*[@id='finish']")).text
    driver.navigate().back()
}

Then(~'I get the position of exit intent element'){->
    WebElement element = driver.findElement(By.xpath("//div[@class='example']"))
    Locatable locate = (Locatable)element
    int yPosition = locate.coordinates.onPage().y
    robot.mouseMove(0,yPosition-30)
    Thread.sleep(5000)
    driver.switchTo().activeElement()
    WebElement footerElement = driver.findElement(By.xpath("//*[@class='modal-footer']"))

    footerElement.click()
}

After(){
   //driver.close()
}