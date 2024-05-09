package com.example.demo.models;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SharedLongToShortHashMap {
    private HashMap<String, Long> hashMap;

    public SharedLongToShortHashMap() {
        this.hashMap = new HashMap<>();
        // You can initialize the HashMap with default values if needed
    }

    public HashMap<String, Long> getHashMap() {
        return hashMap;
    }

    // You can add methods to manipulate the HashMap as needed
}
