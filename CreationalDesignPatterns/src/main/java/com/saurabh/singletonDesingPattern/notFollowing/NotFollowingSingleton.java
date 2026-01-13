package com.saurabh.singletonDesingPattern.notFollowing;

public class NotFollowingSingleton {
    public static void main(String[] args) {
        AppSettings appSettings = new AppSettings();
        AppSettings appSettings1 = new AppSettings();

        // creating another object for AppSetting is allowed which shhould not be as having multiple objects can cause issues
        // and will take more memory

    }
}
