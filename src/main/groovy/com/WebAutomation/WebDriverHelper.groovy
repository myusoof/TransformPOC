package com.WebAutomation

import org.codehaus.plexus.configuration.processor.ConfigurationResourceHandler
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

    public static WebElement FindElementWithJQuery(WebDriver driver, String JQuerySelector){
        WebElement element = ((JavascriptExecutor)(driver)).executeScript("""return jQuery("$JQuerySelector").get(0)""")
        element
    }


    public static List<WebElement> FindElementsWithJQuery(WebDriver driver, String JQuerySelector){
        def elements = ((JavascriptExecutor)(driver)).executeScript("""return \$('$JQuerySelector').get()""")
        elements
    }
}
