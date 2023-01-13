package com.example.minhnamorder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MinhNamOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinhNamOrderApplication.class, args);
        log.info("Server running...");
    }

}
