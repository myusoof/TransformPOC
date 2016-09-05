package com.WebAutomation

import java.awt.Robot
import java.awt.event.KeyEvent

/**
 * Created by yusoof on 5/9/16.
 */
public class DialogHelper implements Runnable{

    void run() {
        enterCredentials()
    }

    public void enterCredentials(){
        Thread.sleep(5000)
        enterText("admin")
        enterSpecialChar(KeyEvent.VK_TAB)
        enterText("admin")
        enterSpecialChar(KeyEvent.VK_ENTER)

    }
    public void enterText(String textToEnter){
        byte[] bytes = textToEnter.getBytes();
        Robot robot = new Robot()
        for (byte b : bytes) {
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (b> 96 && b< 123)
                b = b - 32
            robot.delay(40);
            robot.keyPress(b);
            robot.keyRelease(b);
        }
    }

    private void enterSpecialChar(int s) {
        Robot robot = new Robot();
        robot.delay(40);
        robot.keyPress(s);
        robot.keyRelease(s);
    }
}
