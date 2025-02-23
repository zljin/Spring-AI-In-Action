package com.zljin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {
    public static void main(String[] args) {
//        setUpProxy();
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.status(200).body("success");
    }

    private static void setUpProxy() {
        System.setProperty("proxyHost", "127.0.0.1");
        System.setProperty("proxyPort", "18888");
        System.setProperty("proxySet", "true");
        System.setProperty("proxyType", "4");
    }
}
