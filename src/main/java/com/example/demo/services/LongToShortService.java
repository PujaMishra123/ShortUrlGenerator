package com.example.demo.services;

import com.example.demo.models.SharedLongToShortHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LongToShortService {
    private SharedLongToShortHashMap sharedHashMap;

    @Autowired
    public LongToShortService (SharedLongToShortHashMap sharedHashMap) {
        this.sharedHashMap = sharedHashMap;
    }

    public void addToHashMap(String key, Long value) {
        sharedHashMap.getHashMap().put(key, value);
    }
    public Long getValue(String key)
    {
        return sharedHashMap.getHashMap().get(key);
    }
}
