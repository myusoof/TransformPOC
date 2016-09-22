package com.WebAutomation

/**
 * Created by yusoof on 21/9/16.
 */
public enum BrowserSize {

    Desktop(1024,768),
    Mobile(420,600),
    Tablet(1024,600)


    public int height
    public int width

    public BrowserSize(int width, int height){
        this.width = width
        this.height = height
    }
}