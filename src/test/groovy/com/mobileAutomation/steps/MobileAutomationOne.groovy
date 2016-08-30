package com.mobileAutomation.steps

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AutomationName
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.service.local.AppiumDriverLocalService
import io.appium.java_client.service.local.AppiumServiceBuilder
import io.appium.java_client.service.local.flags.GeneralServerFlag
import io.selendroid.common.SelendroidCapabilities
import org.junit.Assert
import org.openqa.selenium.Platform
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

/**
 * Created by yusoof on 20/6/16.
 */
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


Given(~'I have the appium server configured'){ ->
   AppiumServiceBuilder builder = new AppiumServiceBuilder()
            .withAppiumJS(new File("/usr/lib/node_modules/appium/build/lib/main.js"))
            //.withArgument(GeneralServerFlag.APP, System.getProperty("user.dir") + "/build/wordpress.apk")
            .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
            .withLogFile(new File(System.getProperty("user.dir") + "/target/logs/sample.txt"))
            .usingPort(4723)
    //* and so on *//*;
    appiumDriverLocalService = builder.build();
    appiumDriverLocalService.start();
    println System.getProperty("user.dir") + "/target/logs/sample.txt"
    //def appiumServer = AppiumDriverLocalService.buildDefaultService()
    //appiumServer.start()
}

Given(~'I would like to start the appium server'){->
    AppiumServiceBuilder builder = new AppiumServiceBuilder()
            .withAppiumJS(new File("/usr/lib/node_modules/appium/build/lib/main.js"))
    //.withArgument(GeneralServerFlag.APP, System.getProperty("user.dir") + "/build/wordpress.apk")
            //.withArgument(GeneralServerFlag.LOG_LEVEL, "info")
            //.withLogFile(new File(System.getProperty("user.dir") + "/target/logs/sample.txt"))
            .usingPort(4723)
    //* and so on *//*;
    appiumDriverLocalService = builder.build();
    appiumDriverLocalService.start();
    if (appiumDriverLocalService == null || !appiumDriverLocalService.isRunning()) {
        throw new RuntimeException("An appium server node is not started!");
    }

    File appDir = new File("src/test/resources");
    File app = new File(appDir, "chrome_39.apk");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setPlatform(Platform.ANDROID);
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
    //capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath().toString());
    //capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,"com.android.chrome");
    driver = new AndroidDriver<>(appiumDriverLocalService.getUrl(), capabilities);
    driver.launchApp()
    driver.navigate().to("http://bing.com/")
}

Given(~'I would like to start the selenroid server'){->
    AppiumServiceBuilder builder = new AppiumServiceBuilder();
    service = builder.usingPort(4444).build();
    service.start();
    File appDir = new File("/home/yusoof/Downloads/TransformPoC/src/test/resources");
    File app = new File(appDir, "chrome_39.apk");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
    //capabilities.setCapability(MobileCapabilityType.SELENDROID_PORT, "9999");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
    //driver = new AndroidDriver<WebElement>(service.getUrl(), capabilities);
//    SelendroidCapabilities capabilities = new SelendroidCapabilities()
    //WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.android());
    AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.android());
    driver.navigate().to("http://bing.com")
}