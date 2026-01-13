package com.saurabh.abstractFactoryPattern.following;


public class Application {
    private KeyBoard keyBoard;
    private ScrollBar scrollBar;

    Application(UIFactory uiFactory) {
        this.keyBoard = uiFactory.createKeyBoard();
        this.scrollBar = uiFactory.createScrollBar();
    }

    public void renderUi() {
        keyBoard.render();
        scrollBar.scroll();
    }

    public static void main(String[] args) {
        UIFactory uiFactory = new WindowsFactory();
        Application application = new Application(new MacFactory());

        application.renderUi();
    }
}
