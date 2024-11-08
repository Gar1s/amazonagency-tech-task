package com.eddev.amazonagencytechtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AmazonagencyTechTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmazonagencyTechTaskApplication.class, args);
    }

}
