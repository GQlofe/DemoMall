package com.qiang.demomall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RefreshScope
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class DemomallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemomallGatewayApplication.class, args);
    }

}
