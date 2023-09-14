package com.qiang.demomall.ordercenter.config;

import com.qiang.demomall.ordercenter.config.intercetpor.ContextHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description web配置
 *
 * @author qiang
 * @date 2023-09-10 00:02:33
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new ContextHandlerInterceptor())
                // 注意这里路径需要去掉 application.yml中配置的context-path
                .addPathPatterns("/**");  //故这里完整路径是 /mall/user/**
//                .excludePathPatterns("/auth/**"); //故这里完整路径是 /mall/user/auth/**
    }


}
