package com.qiang.demomall.usercenter.domain.userauth.objval;

import lombok.Builder;
import lombok.Data;

/**
 * @description 认证信息
 *
 * @author qiang
 * @date 2023-09-07 22:58:58
 */
@Data
@Builder
public class AuthInfo {

    private String userName;

    private String password;
}
