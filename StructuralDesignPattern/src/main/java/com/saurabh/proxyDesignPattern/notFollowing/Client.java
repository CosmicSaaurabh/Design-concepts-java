package com.saurabh.proxyDesignPattern.notFollowing;

import com.saurabh.proxyDesignPattern.following.ProxyImage;

public class Client {
    public static void main(String[] args) {
//        Image image1 = new RealImage("Photo1.jpg");
//        image1.display(); // displays the high-resolution image

//        Image image2 = new RealImage("Photo1.jpg"); // loading image twice which already loaded once, hence again wasting resources
//        image2.display(); //displays the high-resolution image again


        // we can see that RealImage is being created twice for the same image, leading to redundant loading operations.
        // we should load the image whne image1.display() is called for the first time and then reuse it for image2.display() using caching.

        Image image1 = new ProxyImage("Photo1.jpg");
        Image image2 = new ProxyImage("Photo1.jpg"); // image2 is never loaded as its display function is never called
        image1.display(); // displays the high-resolution image and loads it
        image1.display(); //displays the high-resolution image without loading it again from cache
    }
}
