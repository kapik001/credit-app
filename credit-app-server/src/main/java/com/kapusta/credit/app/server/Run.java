package com.kapusta.credit.app.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kapusta.security.user"})
public class Run {
    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }

}
