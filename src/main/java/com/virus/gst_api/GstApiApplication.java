package com.virus.gst_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.virus")

public class GstApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GstApiApplication.class, args);
    }

}
