package com.example.demo.controllers;

import com.example.demo.models.LongUrlNotUniqueException;
import com.example.demo.models.ShortUrlNotFoundException;
import com.example.demo.services.UrlShortenerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@ResponseBody
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlService;

    @GetMapping("/{shortUrl}")
    public void redirect(@PathVariable String shortUrl, HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String longUrl=urlService.convertShortToLong(shortUrl);
        if(longUrl.equals(null))
            throw new ShortUrlNotFoundException(shortUrl);
        response.sendRedirect(longUrl);
    }

    @PostMapping("/shorten")
    public String getShortUrl(@RequestBody String longUrl)
    {
        String shortUrl=urlService.convertLongToShort(longUrl);
        if(shortUrl.equals(null))
            throw new LongUrlNotUniqueException(longUrl);
        return shortUrl;

    }






}
