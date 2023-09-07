package com.qiang.demomall.common.annotations;

import java.lang.annotation.*;

/**
 * @Description:
 * @Auther: Administrator
 * @Date: 2018/10/30
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PrintLog {


    boolean before() default true;

    boolean after() default true;
}
