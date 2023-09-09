package com.qiang.demomall.gateway.route;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import com.alibaba.nacos.common.utils.MD5Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description 自动刷新路由
 *
 * @author qiang
 * @date 2023-08-27 10:55:03
 */
@Slf4j
@Component
public class AutoRefreshRouter implements ApplicationRunner {

    @Autowired
    private NacosConfigManager nacosConfigManager;

    @Autowired
    private GatewayRouterRegister routerRegister;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final Map<String, NacosConfigItem> routerCache = new ConcurrentHashMap<>();


    @Override
    public void run(ApplicationArguments args) throws Exception {
        ConfigService configService = nacosConfigManager.getConfigService();
        configService.addListener("demomall-gateway.properties", "DEV", new NacosConfigListener());

        // 初始化配置
        String config = configService.getConfig("demomall-gateway.properties", "DEV", 5000);

        Map<String, RouteDefinition> map = resolveConfig(config);
        if (CollectionUtils.isEmpty(map)) {
            log.info("没有配置信息");
            return;
        }
        for (RouteDefinition router : map.values()) {

            log.info("初始化配置 routerId={}", router.getId());

            routerRegister.add(router);

            String md5 = MD5Utils.md5Hex(router.toString(), "UTF-8");

            routerCache.put(router.getId(), new NacosConfigItem(router.getId(), router, md5));
        }
        log.info("init routerCache={}", routerCache);
    }


    private Map<String, RouteDefinition> resolveConfig(String configInfo) {
        List<RouteDefinition> list = null;
        try {
            list = objectMapper.readValue(configInfo, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            log.error("解析路由信息异常 e=", e);
        }
        Map<String, RouteDefinition> map = new HashMap<>();

        if (CollectionUtils.isEmpty(list)) {
            return map;
        }

        for (RouteDefinition routeDefinition : list) {
            map.put(routeDefinition.getId(), routeDefinition);
        }

        return map;
    }



    private class NacosConfigListener extends AbstractListener {


        @Override
        public void receiveConfigInfo(String configInfo) {
            log.info("路由配置信息configInfo={}", configInfo);


            Map<String, RouteDefinition> map = resolveConfig(configInfo);
            if (CollectionUtils.isEmpty(map)) {
                return;
            }

            // 删除
            List<String> removeList = routerCache.keySet().stream().filter(k -> !map.containsKey(k)).toList();
            for (String routerId : removeList) {
                log.info("删除配置 routerId={}", routerId);
                routerCache.remove(routerId);
                routerRegister.delete(routerId);
            }

            map.forEach((routerId, router) -> {
                String md5 = MD5Utils.md5Hex(router.toString(), "UTF-8");

                NacosConfigItem nacosConfigItem = routerCache.get(routerId);

                // 新增
                if (nacosConfigItem == null) {
                    log.info("新增配置 routerId={}", routerId);
                    routerRegister.add(router);
                    routerCache.put(router.getId(), new NacosConfigItem(router.getId(), router, md5));
                    return;
                }

                // 配置不变，忽略
                if (md5.equals(nacosConfigItem.getMd5())) {
                    return;
                }

                // 更新
                log.info("更新配置 routerId={}", routerId);
                routerRegister.update(router);
                routerCache.put(router.getId(), new NacosConfigItem(router.getId(), router, md5));

            });
        }
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    private static class NacosConfigItem {

        private String routerId;

        private RouteDefinition router;

        private String md5;

    }
}
