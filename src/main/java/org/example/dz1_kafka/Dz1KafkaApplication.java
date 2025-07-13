package org.example.dz1_kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Dz1KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(Dz1KafkaApplication.class, args);
    }

}

