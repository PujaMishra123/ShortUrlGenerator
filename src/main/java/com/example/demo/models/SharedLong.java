package com.example.demo.models;

import org.springframework.stereotype.Component;

@Component
public class SharedLong {
    private long sharedValue;

    public SharedLong() {
        // Initialize the shared value as needed
        this.sharedValue = 100000000000L;
    }

    public synchronized long getSharedValue() {
        return sharedValue;
    }

    public synchronized void setSharedValue(long sharedValue) {
        this.sharedValue = sharedValue;
    }

    // You can add other synchronized methods to manipulate the shared value as needed
}
