package com.qiang.demomall.common.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 全局错误码枚举
 *
 * @author qiang
 * @date 2023-08-20 19:29:40
 */
@Getter
public enum ErrorCodeEnum {
    SUCCESS(0, "success"),

    //1001 - 1999 常规错误类型
    PARAM_ERROR(1001, "参数错误"),
    SYSTEM_ERROR(1002, "系统异常"),
    NETWORK_ERROR(1003, "网络异常"),
    OPERATE_ERROR(1004, "数据库操作失败"),
    NO_TOKEN_ERROR(1005, "未设置token"),
    OPERATE_FAST(1006, "操作过频，请稍后重试"),


    // 认证服务 2001 - 2999
    ERROR_2001(2001, "用户名或密码错误"),
    ERROR_2002(2002, "登录已失效，清重新登录"),
    ERROR_2003(2003, "用户名已被注册"),


    // 商品服务 3001 - 3999
    ERROR_3001(3001, "该商品不存在"),


    // 用户服务  购物车 4001 - 4100
    ERROR_4001(4001, "加入购物车失败"),
    ERROR_4002(4002, "更新购物车商品失败"),
    ERROR_4003(4003, "未设置交易密码"),

    // 用户服务  收藏 4101 - 4200
    ERROR_4101(4101, "收藏商品失败"),

    // 用户服务  收货地址 4201 - 4300
    ERROR_4201(4201, "该收货地址不存在"),


    // 订单服务  购物车 5001 - 5999
    ERROR_5001(5001, "该订单不存在"),
    ERROR_5002(5002, "选择的商品不存在"),
    ERROR_5003(5003, "商品库存不足"),
    ERROR_5004(5004, "下单失败，更新订单状态和金额失败"),

    // 支付服务  购物车 6001 - 6999
    ERROR_6001(6001, "余额不足"),

    ;

    private final int code;
    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public static Map<Integer, ErrorCodeEnum> map = new HashMap<>();

    static {
        for (ErrorCodeEnum e : ErrorCodeEnum.values()) {
            map.put(e.code, e);
        }
    }


    /**
     * 通过错误码code获取枚举值
     * @param code 错误码
     * @return 枚举值
     */
    public static ErrorCodeEnum getByCode(int code) {
        return map.get(code);
    }
}
