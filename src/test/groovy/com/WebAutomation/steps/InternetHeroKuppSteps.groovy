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
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.security.UserAndPassword


/**
 * Created by yusoof on 3/9/16.
 */
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

@Field
WebDriver driver = WebDriverHelper.createWebDriverInstance(ConfigurationHelper.driverType)

@Field
RestClient client = RestClient.getRestInstance()

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
After(){
   //driver.close()
}