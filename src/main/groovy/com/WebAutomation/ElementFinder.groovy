package com.WebAutomation

import com.google.api.client.json.Json
import groovy.json.JsonSlurper

/**
 * Created by yusoof on 22/9/16.
 */
public class ElementFinder {
    public static Object loadJsonFile(File file){
        return new JsonSlurper().parse(file)
    }



}
