package com.qiang.demomall.gateway.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.reactor.context.SaReactorSyncHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.qiang.demomall.common.enums.ErrorCodeEnum;
import com.qiang.demomall.common.response.MallResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

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
                .addExclude("/mall/user/auth/**")

                // 校验前
                .setBeforeAuth(obj -> {
                    // ---------- 设置跨域响应头 ----------
                    SaHolder.getResponse()
                            // 允许指定域访问跨域资源
                            .setHeader("Access-Control-Allow-Origin", "*")
                            // 允许所有请求方式
                            .setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
                            // 有效时间
                            .setHeader("Access-Control-Max-Age", "3600")
                            // 允许的header参数
                            .setHeader("Access-Control-Allow-Headers", "*");

                    // 如果是预检请求，则立即返回到前端
                    SaRouter.match(SaHttpMethod.OPTIONS)
                            .free(r -> System.out.println("--------OPTIONS预检请求，不做处理"))
                            .back();
                })
                // 指定[认证函数]: 每次请求执行
                .setAuth(obj  -> {
                    // 登录校验 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
                    SaRouter.match("/mall/**", "/mall/user/auth/**", r -> StpUtil.checkLogin());
                    long uid = StpUtil.getSession().getLong("uid");
                    log.info("SaReactorFilter uid={}",uid);
                    ServerWebExchange exchange = SaReactorSyncHolder.getContext();
                    ServerHttpRequest request = exchange.getRequest().mutate().headers(h -> h.set("uid", String.valueOf(uid))).build();

                    ServerWebExchange ex = exchange.mutate().request(request).build();
                    SaReactorSyncHolder.setContext(ex);


                    // 角色认证 -- 拦截以 admin 开头的路由，必须具备 admin 角色或者 super-admin 角色才可以通过认证
//                    SaRouter.match("/admin/**", r -> StpUtil.checkRoleOr("admin", "super-admin"));
                    // 权限认证 -- 不同模块, 校验不同权限
//                    SaRouter.match("/meta-system/**", r -> StpUtil.checkPermission("system-no"));
//                    SaRouter.match("/admin/**", r -> StpUtil.checkPermission("admin"));
//                    SaRouter.match("/goods/**", r -> StpUtil.checkPermission("goods"));
//                    SaRouter.match("/orders/**", r -> StpUtil.checkPermission("orders"));
                })
                // 指定[异常处理函数]：每次[认证函数]发生异常时执行此函数
                .setError(e -> {
                    log.info("sa全局异常 e=",e);
                    return MallResponse.fail(ErrorCodeEnum.ERROR_2002, e.getMessage());
                });
    }
}


