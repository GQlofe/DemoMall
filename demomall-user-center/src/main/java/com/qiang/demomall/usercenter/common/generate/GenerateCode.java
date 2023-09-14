package com.qiang.demomall.usercenter.common.generate;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @description MybatisPlus代码生成器
 *
 * @author qiang
 * @date 2023-08-28 23:16:04
 */
public class GenerateCode {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/demomall";
        String username = "root";
        String password = "root";
        String author = "qiang";

        String dir = "D://tmp";
        String mapperDir = dir + "/mapper";

        String packageName = "com.qiang.demomall";

        String moduleName = "productcenter.repository";
        String tableName = "tb_product_spu";


        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
                            .outputDir(dir); // 指定输出目录
                })
//                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
//                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
//                    if (typeCode == Types.SMALLINT) {
//                        // 自定义类型转换
//                        return DbColumnType.INTEGER;
//                    }
//                    return typeRegistry.getColumnType(metaInfo);
//
//                }))
                .packageConfig(builder -> {
                    builder.parent(packageName) // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperDir)); // 设置mapperXml生成路径
                })
                .templateConfig(builder -> {
                    builder.disable(TemplateType.CONTROLLER,TemplateType.SERVICE);
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tableName) // 设置需要生成的表名
                            .addTablePrefix("tb_")// 设置过滤表前缀
                            // Entity 策略配置
                            .entityBuilder()
                            .enableLombok() //开启 Lombok
                            .enableFileOverride() // 覆盖已生成文件
                            .formatFileName("%sDO")
                            .naming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略：下划线转驼峰命
                            .columnNaming(NamingStrategy.underline_to_camel)    //数据库表字段映射到实体的命名策略：下划线转驼峰命
                            // Mapper 策略配置
                            .mapperBuilder()
                            .enableBaseColumnList()
                            .enableBaseResultMap()
                            .enableFileOverride() // 覆盖已生成文件
                            // Service 策略配置
                            .serviceBuilder()
                            .convertServiceImplFileName(entityName -> entityName + "Dao")
//                            .superServiceImplClass("")
//                            .enableFileOverride() // 覆盖已生成文件
//                            .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
//                            .formatServiceImplFileName("%sDao") //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl
                            // Controller 策略配置
//                            .controllerBuilder()
//                            .enableFileOverride()
                    ; // 覆盖已生成文件

                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
