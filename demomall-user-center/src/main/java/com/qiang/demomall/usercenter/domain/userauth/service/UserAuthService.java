package com.qiang.demomall.usercenter.domain.userauth.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.qiang.demomall.common.dto.usercenter.UserAuthDTO;
import com.qiang.demomall.common.enums.usercenter.UserAuthModeEnum;

/**
 * @description 用户认证领域服务
 *
 * @author qiang
 * @date 2023-09-07 22:52:08
 */
public interface UserAuthService {

    /**
     * 服务支持认证模式
     * @return
     */
    UserAuthModeEnum support();


    /**
     * 登录
     * @param userAuthDTO 认证信息
     * @return token信息
     */
    SaTokenInfo login(UserAuthDTO userAuthDTO);
}
