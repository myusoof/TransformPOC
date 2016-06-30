package com.mobileAutomation

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

/**
 * Created by mohmedyusoof.as on 5/30/2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions( plugin = ["pretty", "html:target/cucumber", "json:target/cucumber-report.json"], features = ["src/test/groovy/com/mobileAutomation/features"],glue = ["src/test/groovy/com/mobileAutomation/steps"])
public class RunCukesTest {
}