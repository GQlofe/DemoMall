package com.qiang.demomall.gateway.config;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.stp.StpUtil;
import com.qiang.demomall.common.enums.ErrorCodeEnum;
import com.qiang.demomall.common.response.MallResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description sa-token配置类
 *
 * @author qiang
 * @date 2023-09-07 22:25:22
 */
@Slf4j
@Configuration
public class SaTokenConfigure {


    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 指定 [拦截路由]
                .addInclude("/mall/**")
                // 指定 [放行路由]
                .addExclude("/favicon.ico")
                // 指定[认证函数]: 每次请求执行
                .setAuth(r -> {
                    log.info("sa全局认证");
                    StpUtil.checkLogin();
                })
                // 指定[异常处理函数]：每次[认证函数]发生异常时执行此函数
                .setError(e -> {
                    log.info("sa全局异常");
                    return MallResponse.fail(ErrorCodeEnum.ERROR_2002, e.getMessage());
                });
    }
}


