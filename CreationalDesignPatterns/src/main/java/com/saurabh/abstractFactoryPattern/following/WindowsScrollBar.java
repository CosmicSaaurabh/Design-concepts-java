package com.saurabh.abstractFactoryPattern.following;

public class WindowsScrollBar implements ScrollBar{
    @Override
    public void scroll() {
        System.out.println("Scrolling windows scroll bar");
    }
}
