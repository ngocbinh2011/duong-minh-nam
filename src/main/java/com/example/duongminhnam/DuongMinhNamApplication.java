package com.example.duongminhnam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DuongMinhNamApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuongMinhNamApplication.class, args);
        log.info("Server running...");
    }

}
