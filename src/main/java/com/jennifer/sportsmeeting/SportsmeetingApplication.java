package com.jennifer.sportsmeeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SportsmeetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsmeetingApplication.class, args);
    }

}
