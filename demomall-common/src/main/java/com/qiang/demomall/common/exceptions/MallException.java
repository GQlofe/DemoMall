package com.qiang.demomall.common.exceptions;

import com.qiang.demomall.common.enums.ErrorCodeEnum;
import com.qiang.demomall.common.response.MallResponse;
import lombok.Getter;
import lombok.ToString;

/**
 * @description 全局统一异常对象
 *
 * @author qiang
 * @date 2023-08-20 20:59:12
 */
@Getter
@ToString
public class MallException extends RuntimeException {

    // 错误码
    protected int code;

    // 错误信息
    protected String msg;


    public MallException(ErrorCodeEnum errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }

    public MallException(ErrorCodeEnum errorCode, String msg) {
        this.code = errorCode.getCode();
        this.msg = msg;
    }

    public MallException(MallResponse<?> response) {
        super();
        this.code = response.getCode();
        this.msg = response.getMessage();
    }

}
