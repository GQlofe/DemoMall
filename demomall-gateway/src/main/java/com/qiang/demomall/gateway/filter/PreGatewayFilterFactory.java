package com.qiang.demomall.gateway.filter;

import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;

/**
 * @description 前置过滤器
 *
 * @author qiang
 * @date 2023-09-09 22:05:36
 */
@Slf4j
//@Component
public class PreGatewayFilterFactory extends AbstractGatewayFilterFactory<PreGatewayFilterFactory.Config> {

    public PreGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // grab configuration from Config object
        return (exchange, chain) -> {
            HttpHeaders headers = exchange.getRequest().getHeaders();
            long uid = StpUtil.getSession().getLong("uid");
            log.info("SaReactorFilter uid={}",uid);

            headers.add("uid", String.valueOf(uid));

            return chain.filter(exchange);
        };
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }
}
