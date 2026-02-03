package com.saurabh;

import java.time.Duration;
import java.time.LocalDateTime;

public class SeatLock {
    private final LocalDateTime lockedAt;
    private final int timeoutSeconds;

    public SeatLock(LocalDateTime lockedAt, int timeoutSeconds) {
        this.lockedAt = lockedAt;
        this.timeoutSeconds = timeoutSeconds;
    }
}
