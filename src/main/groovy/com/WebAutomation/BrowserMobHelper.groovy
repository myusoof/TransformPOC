package com.WebAutomation

import net.lightbody.bmp.BrowserMobProxy
import net.lightbody.bmp.BrowserMobProxyServer
import net.lightbody.bmp.client.ClientUtil
import net.lightbody.bmp.core.har.Har
import org.apache.regexp.RE

/**
 * Created by yusoof on 17/9/16.
 */
public class BrowserMobHelper {

    public static BrowserMobProxy proxy = null

    public static void startProxy(){
        proxy = new BrowserMobProxyServer();
        proxy.start(0);
    }

    public static void createHAR(String harFileName){
        proxy.newHar(harFileName)
    }

    public static org.openqa.selenium.Proxy createWebDriverProxy(){
        org.openqa.selenium.Proxy  seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        return seleniumProxy
    }

    public static Har getHar(){
        proxy.getHar()
    }

    public static closeProxy(){
        proxy.stop()
    }

}
