package com.mobileAutomation.steps

import io.appium.java_client.service.local.AppiumDriverLocalService
import io.appium.java_client.service.local.AppiumServiceBuilder
import io.appium.java_client.service.local.flags.GeneralServerFlag
import org.junit.Assert

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