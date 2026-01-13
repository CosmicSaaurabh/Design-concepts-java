package com.saurabh.abstractFactoryPattern.following;

public class MacKeyBoard implements KeyBoard{
    @Override
    public void render() {
        System.out.println("Rendering MacOs keyboard");
    }
}
