package com.example.demo.util;

import org.springframework.http.ResponseEntity;

public interface RestClient {
    ResponseEntity<String> get(String uri);
}
