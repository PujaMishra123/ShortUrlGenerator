package com.example.demo.ExceptionHandlers;

import com.example.demo.models.LongUrlNotUniqueException;
import com.example.demo.models.ShortUrlNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ShortUrlNotFoundException.class)
    public ResponseEntity<String> handleShortUrlNotFoundException(ShortUrlNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Short URL not found." + ex.getMessage());
    }

    @ExceptionHandler(LongUrlNotUniqueException.class)
    public ResponseEntity<String> handleLongUrlNotUniqueException(LongUrlNotUniqueException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Short URL not found." + ex.getMessage());
    }


}
