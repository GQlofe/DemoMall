package com.qiang.commoditycenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DemomallCommodityCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemomallCommodityCenterApplication.class, args);
    }

}
