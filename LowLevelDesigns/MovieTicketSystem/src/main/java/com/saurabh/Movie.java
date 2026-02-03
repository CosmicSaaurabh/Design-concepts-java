package com.saurabh;

import java.time.Duration;

public class Movie {
    private final String movieName;
    private final Duration duration;

    public Movie(String movieName, Duration duration) {
        this.movieName = movieName;
        this.duration = duration;
    }
}
