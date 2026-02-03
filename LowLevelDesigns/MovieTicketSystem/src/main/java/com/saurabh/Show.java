package com.saurabh;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Show {
    private final Movie movieName;
    private final LocalDateTime showTime;
    private volatile List<List<ShowSeat>> showSeats;


    public Show(Movie movieName, LocalDateTime showTime) {
        this.movieName = movieName;
        this.showTime = showTime;
    }
}
