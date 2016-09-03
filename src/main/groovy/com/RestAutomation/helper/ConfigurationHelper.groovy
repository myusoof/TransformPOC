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



    public static String getDriverInstance(){
        return getProperties().get("driver")
    }

    public static String getTags(){
        return getProperties().get("tags")
    }

    public static String webappliationbaseurl(){
        return getProperties().get("webappliationbaseurl")
    }
}
