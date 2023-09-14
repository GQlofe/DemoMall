package com.qiang.demomall.ordercenter.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description 数据库配置类
 *
 * @author qiang
 * @date 2023-09-02 10:01:11
 */
@Configuration
@MapperScan("com.qiang.demomall.ordercenter.repository.mapper")
public class DataSourceConfiguration {
}
