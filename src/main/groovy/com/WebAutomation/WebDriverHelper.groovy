package com.WebAutomation

import org.codehaus.plexus.configuration.processor.ConfigurationResourceHandler
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.opera.OperaDriver
import org.openqa.selenium.safari.SafariDriver

/**
 * Created by yusoof on 31/8/16.
 */
public class WebDriverHelper {

    private static WebDriver driver = null;
    public static createWebDriverInstance(String driverType){
        if(driver == null){
            switch (driverType){
                case "firefox":
                    driver  = new FirefoxDriver();
                    break;
                case "IE":
                    driver = new InternetExplorerDriver();
                    break;
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "opera":
                    driver = new OperaDriver();
                    break;
                default:
                    driver = new FirefoxDriver();
                    break;
            }
        }
        return driver;
    }

    public static WebElement FindElementWithJQuery(String JQuerySelector){
        WebElement element = ((JavascriptExecutor)(driver)).executeScript("""return jQuery("$JQuerySelector").get(0)""")
        element
    }

    public static List<WebElement> FindElementsWithJQuery(String JQuerySelector){
        def elements = ((JavascriptExecutor)(driver)).executeScript("""return \$('$JQuerySelector').get()""")
        elements
    }
    public static By ByWhat(String type, String elementLocator){
        switch (type.toLowerCase()){
            case "xpath":
                return By.xpath(elementLocator)
            case "classname":
                return By.className(elementLocator)
            case "cssSelector":
                return By.cssSelector(elementLocator)
            case "id":
                return By.id(elementLocator)
            case "linkText":
                return By.linkText(elementLocator)
            case "name":
                return By.name(elementLocator)
            case "partialLinkText":
                return By.partialLinkText(elementLocator)
            case "tagName":
                return By.tagName(elementLocator)
            default:
                return By.xpath(elementLocator)
        }
    }
}
