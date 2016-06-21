package com.mobileAutomation.steps

import io.appium.java_client.service.local.AppiumDriverLocalService
import org.junit.Assert

/**
 * Created by yusoof on 20/6/16.
 */
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)



Given(~'I have the appium server configured'){->
    def appiumServer = AppiumDriverLocalService.buildDefaultService()
    appiumServer.start()
}