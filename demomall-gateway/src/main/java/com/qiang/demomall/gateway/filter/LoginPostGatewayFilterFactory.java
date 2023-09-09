package com.qiang.demomall.gateway.filter;

import com.qiang.demomall.gateway.feign.UserCenterFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

/**
 * @description 登录后置过滤器
 *
 * @author qiang
 * @date 2023-09-09 21:12:54
 */
//@Component
public class LoginPostGatewayFilterFactory extends AbstractGatewayFilterFactory<LoginPostGatewayFilterFactory.Config> {

    @Autowired
    private UserCenterFeign userCenterFeign;

    public  LoginPostGatewayFilterFactory(){
        super(Config.class);
    }


    @Override
    public GatewayFilter apply(Config config) {
        // grab configuration from Config object
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                ServerHttpResponse response = exchange.getResponse();
                //Manipulate the response in some way
            }));
        };
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }
}
