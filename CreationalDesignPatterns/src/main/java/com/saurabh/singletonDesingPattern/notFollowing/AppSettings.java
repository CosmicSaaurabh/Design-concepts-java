package com.saurabh.singletonDesingPattern.notFollowing;

public class AppSettings {
    private String databaseUrl;
    private String apiKey;

    AppSettings() {
        // read from the config file
        this.databaseUrl = "databaseurl";
        this.apiKey = "apikey";
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}
