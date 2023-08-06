package com.example.testspringredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestspringredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestspringredisApplication.class, args);
    }

}
