package com.RestAutomation.helper
import org.openqa.selenium.WebDriver

/**
 * Created by mohmedyusoof.as on 5/27/2016.
 */
public class ConfigurationHelper {

    static Properties properties

    public static Properties getProperties(){
        properties = new Properties()
        properties.load(this.getClass().getResourceAsStream("/properties/configuration.properties"))
        return properties
    }

    public static String getDriverType(){
        return ConfigurationHelper.getProperties().get("driver")
    }

    public static String getTags(){
        return ConfigurationHelper.getProperties().get("tags")
    }

    public static String getWebAppliationBaseUrl(){
        return ConfigurationHelper.getProperties().get("webappliationbaseurl")
    }

    public static String getEmailAddress(){
        return ConfigurationHelper.getProperties().get("emailAddress")
    }
    public static String getMailServer(){
        return ConfigurationHelper.getProperties().get("mailServer")
    }
    public static String getEmailPassword(){
        return ConfigurationHelper.getProperties().get("emailPassword")
    }
}
