package com.RestAutomation.helper
import org.openqa.selenium.WebDriver

/**
 * Created by mohmedyusoof.as on 5/27/2016.
 */
public class ConfigurationHelper {

    static RestClient restClient = new RestClient(ConfigurationHelper.getProperties().get("baseUrl"))
    static Properties properties

    public static Properties getProperties(){
        properties = new Properties()
        properties.load(this.getClass().getResourceAsStream("/properties/configuration.properties"))
        return properties
    }

    public static RestClient getRestInstance(){
        if(restClient == null){
            return new RestClient(ConfigurationHelper.getProperties().get("baseUrl"))
        }
        return restClient
    }

    public static String getDriverType(){
        if(restClient == null){
            return new RestClient(ConfigurationHelper.getProperties().get("driver"))
        }
        return restClient
    }

    public static String getTags(){
        return ConfigurationHelper.getProperties().get("tags")
    }

    public static String webappliationbaseurl(){
        return ConfigurationHelper.getProperties().get("webappliationbaseurl")
    }
}
