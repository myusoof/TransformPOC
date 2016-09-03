package com.WebAutomation.steps

import com.WebAutomation.WebDriverHelper
import groovy.transform.Field
import org.openqa.selenium.WebDriver


/**
 * Created by yusoof on 3/9/16.
 */
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

@Field
WebDriver driver = WebDriverHelper.createWebDriverInstance()

Given(~'I Launch the "firefox" browser'){

}