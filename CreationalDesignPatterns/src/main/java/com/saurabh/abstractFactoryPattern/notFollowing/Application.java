package com.saurabh.abstractFactoryPattern.notFollowing;


class MacScrollBar {
    public void scroll() {
        System.out.println("scrolling mac scroll bar...");
    }
}
class MackeyBoard {
    public void render() {
        System.out.println("Rendering mac key board...");
    }
}
class WindowKeyScrollBar {
    public void scroll() {
        System.out.println("scrolling windows scroll bar...");
    }
}
class WindowKeyBoard {
    public void render() {
        System.out.println("Rendering windows key board...");
    }
}
public class Application {
    public static void main(String[] args) {
        WindowKeyBoard board = new WindowKeyBoard();
//        WindowKeyScrollBar scrollBar = new WindowKeyScrollBar();

        MacScrollBar scrollBar = new MacScrollBar();
        board.render();
        scrollBar.scroll();

        // in client windows button object can be created with macscrollbar which should not be supported as it is logically incorrect
        // currently there is no way to stop this.

        // application is tightly coupled with conceate classes
    }
}
