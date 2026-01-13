package com.saurabh.singletonDesingPattern.following;

public class AppSettings {
    // private static instance of class
    private static AppSettings instance;
    private String databaseUrl;
    private String apiKey;

    // keep constructor private so that instanace creation is limited
    private AppSettings() {
        // read from the config file
        this.databaseUrl = "databaseurl";
        this.apiKey = "apikey";
    }

    // a public method to return the instance ie single instance
    public static AppSettings getInstance() {
        if (instance == null) {
            instance = new AppSettings();
        }

        return instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}
