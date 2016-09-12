package com.WebAutomation

import org.codehaus.plexus.configuration.processor.ConfigurationResourceHandler
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.opera.OperaDriver
import org.openqa.selenium.safari.SafariDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

/**
 * Created by yusoof on 31/8/16.
 */
public class WebDriverHelper {

    private static WebDriver driver = null;
    public static String downloadPath = "/home/yusoof/Downloads/"
    public static createWebDriverInstance(String driverType){
        if(driver == null){
            switch (driverType){
                case "firefox":
                    driver  = new FirefoxDriver(FirefoxDriverProfile());
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

    public static JavascriptExecutor JavaScripExecutor(){
        ((JavascriptExecutor)(driver))
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

    public static void waitForJQuery() {
        (new WebDriverWait(driver, 15)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
            }
        });
    }

    public static WebDriverWait WaitInstance(int time){
        new WebDriverWait(driver,time)
    }
    public static FirefoxProfile FirefoxDriverProfile() throws Exception {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList",10);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", downloadPath);
        profile.setPreference("browser.helperApps.neverAsk.openFile",
                "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.focusWhenStarting", false);
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.closeWhenDone", false);
        return profile;
    }
}
