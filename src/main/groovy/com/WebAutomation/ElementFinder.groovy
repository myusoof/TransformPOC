package com.WebAutomation

import com.google.api.client.json.Json
import groovy.json.JsonSlurper

/**
 * Created by yusoof on 22/9/16.
 */
public class ElementFinder {

    static String globalBrowserSize
    static File file = new File(this.getClass().getResource("/jsonfiles").path)
    static Map<String, Object> jsonObjects = new HashMap<String, Object>()

    public static void loadJsonFiles(){
        if(jsonObjects.isEmpty()){
            file.listFiles().each { file ->
                jsonObjects.put(file.name, new JsonSlurper().parse(file))
            }
        }
    }
    public static Object getJsonObject(String key){
        return jsonObjects.get(key)
    }
}
