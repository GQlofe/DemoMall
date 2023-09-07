package com.qiang.demomall.common.request.usercenter;

import lombok.Data;

/**
 * @description 用户名登录请求对象
 *
 * @author qiang
 * @date 2023-09-07 23:04:08
 */
@Data
public class UserNameLoginReq {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
}
