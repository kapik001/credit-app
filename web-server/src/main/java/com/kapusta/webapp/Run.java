package com.kapusta.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kapusta.webapp"})
public class Run {
    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }

}