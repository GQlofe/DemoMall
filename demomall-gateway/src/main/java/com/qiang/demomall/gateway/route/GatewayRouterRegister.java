package com.qiang.demomall.gateway.route;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @description 网关路由注册器
 *
 * @author qiang
 * @date 2023-08-27 12:02:24
 */
@Slf4j
@Component
public class GatewayRouterRegister implements ApplicationEventPublisherAware {

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;
    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }


    //增加路由
    public void add(RouteDefinition definition) {
        routeDefinitionWriter.save(Mono.just(definition)).subscribe();
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }

    //更新路由
    public void update(RouteDefinition definition) {

        delete(definition.getId());
        routeDefinitionWriter.save(Mono.just(definition)).subscribe();
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }

    //删除路由
    public void delete(String id) {

        routeDefinitionWriter.delete(Mono.just(id)).onErrorResume(NotFoundException.class, e -> {
            log.error("没有找到路由信息，e=", e);
            return null;
        });
    }


}
