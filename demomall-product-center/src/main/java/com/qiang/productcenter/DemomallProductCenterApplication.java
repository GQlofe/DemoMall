package com.qiang.productcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DemomallProductCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemomallProductCenterApplication.class, args);
    }

}
