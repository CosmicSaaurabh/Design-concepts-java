package com.saurabh.abstractFactoryPattern.following;

public class MacScrollBar implements ScrollBar{
    @Override
    public void scroll() {
        System.out.println("Scrolling macOs scroll bar");
    }
}
