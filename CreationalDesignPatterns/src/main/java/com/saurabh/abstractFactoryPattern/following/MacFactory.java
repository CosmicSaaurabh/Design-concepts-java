package com.saurabh.abstractFactoryPattern.following;

public class MacFactory implements UIFactory{
    @Override
    public ScrollBar createScrollBar() {
        return new MacScrollBar();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new MacKeyBoard();
    }
}
