package com.saurabh.proxyDesignPattern.following;

import com.saurabh.proxyDesignPattern.notFollowing.Image;
import com.saurabh.proxyDesignPattern.notFollowing.RealImage;

public class ProxyImage implements Image {
    private String fileName; // proxy holds the file name
    private RealImage realImage; // reference to the real image

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // load the real image only when needed
        }
        realImage.display(); // delegate the display call to the real image
    }
}
