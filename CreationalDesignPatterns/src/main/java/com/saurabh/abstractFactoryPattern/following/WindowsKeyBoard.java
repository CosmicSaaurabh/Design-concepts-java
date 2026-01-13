package com.saurabh.abstractFactoryPattern.following;

public class WindowsKeyBoard implements KeyBoard{
    @Override
    public void render() {
        System.out.println("Rendering windows keyboard");
    }
}
