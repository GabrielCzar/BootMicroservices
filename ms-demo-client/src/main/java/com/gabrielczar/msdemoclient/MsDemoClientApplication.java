package com.gabrielczar.msdemoclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MsDemoClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsDemoClientApplication.class, args);
    }
}

@RefreshScope
@RestController
class MessageRestController {

    @Value("${message: Hello Default}")
    private String message;

    @GetMapping("/message")
    String getMessage() {
        return message;
    }

}