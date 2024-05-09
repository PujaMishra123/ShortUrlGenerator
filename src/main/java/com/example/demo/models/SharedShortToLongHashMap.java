package com.example.demo.models;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SharedShortToLongHashMap {
    private HashMap< Long,String> hashMap;

    public SharedShortToLongHashMap() {
        this.hashMap = new HashMap<>();
        // You can initialize the HashMap with default values if needed
    }

    public HashMap<Long,String> getHashMap() {
        return hashMap;
    }
}
