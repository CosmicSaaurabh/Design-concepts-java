package com.saurabh.abstractFactoryPattern.following;

public class WindowsFactory implements UIFactory{
    @Override
    public ScrollBar createScrollBar() {
        return new WindowsScrollBar();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new WindowsKeyBoard();
    }
}
