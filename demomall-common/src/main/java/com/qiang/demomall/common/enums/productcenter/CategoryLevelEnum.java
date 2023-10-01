package com.qiang.demomall.common.enums.productcenter;

import lombok.Getter;

/**
 * @description 商品类目级别
 *
 * @author qiang
 * @date 2023-10-01 23:35:17
 */
@Getter
public enum CategoryLevelEnum {
    FIRST(1,"第一级"),
    SECOND(2,"第二级"),
    THIRD(3,"第三级"),

    ;

    CategoryLevelEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;

    // 描述
    private String desc;
}
