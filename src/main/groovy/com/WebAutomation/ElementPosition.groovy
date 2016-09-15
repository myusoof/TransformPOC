package com.WebAutomation

import org.openqa.selenium.WebElement

/**
 * Created by yusoof on 16/9/16.
 */
public class ElementPosition {

    int xPosition
    int yPosition
    int height
    int width

    public ElementPosition(WebElement element){
        height = element.getSize().height
        width = element.getSize().width
        xPosition = element.getLocation().x
        yPosition = element.getLocation().y
    }

    public String toString() {
        return "${xPosition},${yPosition},${height},${width}"
    }
}
