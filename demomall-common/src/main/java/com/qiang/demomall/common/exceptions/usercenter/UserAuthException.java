package com.qiang.demomall.common.exceptions.usercenter;

import com.qiang.demomall.common.enums.ErrorCodeEnum;
import com.qiang.demomall.common.exceptions.MallException;
import com.qiang.demomall.common.response.MallResponse;
import lombok.Getter;
import lombok.ToString;

/**
 * @description 用户认证异常
 *
 * @author qiang
 * @date 2023-09-07 23:28:09
 */
@Getter
@ToString
public class UserAuthException extends MallException {

    public UserAuthException(ErrorCodeEnum errorCode) {
        super(errorCode);
    }

    public UserAuthException(ErrorCodeEnum errorCode, String msg) {
        super(errorCode, msg);
    }

    public UserAuthException(MallResponse<?> response) {
        super(response);
    }
}
