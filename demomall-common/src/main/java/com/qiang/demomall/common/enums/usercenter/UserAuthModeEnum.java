package com.qiang.demomall.common.enums.usercenter;

import lombok.Getter;

/**
 * @description 用户认证模式枚举
 *
 * @author qiang
 * @date 2023-09-07 23:41:48
 */
@Getter
public enum UserAuthModeEnum {

    AUTH_ACCOUNT("account","账号密码认证模式"),
    AUTH_PHONE("phone","手机号认证模式"),
    AUTH_EMAIL("email","邮箱认证模式"),

    ;

    UserAuthModeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;

    // 描述
    private String desc;
}
