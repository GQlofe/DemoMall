package com.qiang.demomall.common.enums;

import lombok.Getter;

/**
 * @description 是否常量枚举
 *
 * @author qiang
 * @date 2023-10-02 00:04:05
 */
@Getter
public enum YesNoEnum {
    YES(1,"是"),
    NO(0,"否"),

    ;

    YesNoEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;

    // 描述
    private String desc;
}
