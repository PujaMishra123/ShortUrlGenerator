package com.example.demo.services;

import com.example.demo.models.SharedLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SharedLongService {
    private SharedLong sharedLong;

    @Autowired
    public SharedLongService (SharedLong sharedLong) {
        this.sharedLong = sharedLong;
    }

    public synchronized long getSharedValue() {
        return sharedLong.getSharedValue();
    }

    public synchronized void setSharedValue(long value) {
        sharedLong.setSharedValue(value);
    }
}
