package com.saurabh.singletonDesingPattern.following;

public class FollowingSingleton {
    public static void main(String[] args) {
        AppSettings instance1 = AppSettings.getInstance();
        AppSettings instance2 = AppSettings.getInstance();

        // only one instance of appSettings is created
        if (instance2 == instance1) {
            System.out.println("Same objects");
        }
    }
}
