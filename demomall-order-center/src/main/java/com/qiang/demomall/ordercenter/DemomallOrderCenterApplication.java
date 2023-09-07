package com.qiang.demomall.ordercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DemomallOrderCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemomallOrderCenterApplication.class, args);
    }

}
