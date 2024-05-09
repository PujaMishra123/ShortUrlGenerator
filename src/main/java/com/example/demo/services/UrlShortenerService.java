package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class UrlShortenerService {
    String elements;
    @Value("${host.address}")
    private String address;
    @Autowired
    private ShortToLongService shortToLongService;
    @Autowired
    private LongToShortService longToShortService;
    @Autowired
    private SharedLongService sharedLongService;

    UrlShortenerService() {
        elements = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }
    public String convertLongToShort(String url) {
        String shorturl = base10ToBase62(sharedLongService.getSharedValue());
        if(longToShortService.getValue(url)!=null)
        {
            longToShortService.addToHashMap(url, sharedLongService.getSharedValue());
            shortToLongService.addToHashMap(sharedLongService.getSharedValue(), url);
            sharedLongService.setSharedValue(sharedLongService.getSharedValue()+1);
            return address + shorturl;
        }
        return null;

    }
    public String convertShortToLong(String url) {
        url = url.substring(address.length());
        long n = base62ToBase10(url);
        return shortToLongService.getValue(n);
    }

    public int base62ToBase10(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = n * 62 + convert(s.charAt(i));
        }
        return n;

    }
    public int convert(char c) {
        if (c >= '0' && c <= '9')
            return c - '0';
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 36;
        }
        return -1;
    }
    public String base10ToBase62(long n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, elements.charAt((int) n % 62));
            n /= 62;
        }
        while (sb.length() != 7) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }
}
