package com.gabrielczar.msdiscoveryserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsDiscoveryServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsDiscoveryServerDemoApplication.class, args);
    }
}
