package com.example.demo.services;

import com.example.demo.models.SharedShortToLongHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortToLongService {
    private SharedShortToLongHashMap sharedHashMap;

    @Autowired
    public ShortToLongService (SharedShortToLongHashMap sharedHashMap) {
        this.sharedHashMap = sharedHashMap;
    }

    public void addToHashMap(Long key, String value) {
        sharedHashMap.getHashMap().put(key, value);
    }
    public String getValue(Long key)
    {
       return sharedHashMap.getHashMap().get(key);
    }
}
