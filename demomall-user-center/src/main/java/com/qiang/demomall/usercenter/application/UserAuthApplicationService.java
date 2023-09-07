package com.qiang.demomall.usercenter.application;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.qiang.demomall.common.dto.usercenter.UserAuthDTO;
import com.qiang.demomall.usercenter.domain.userauth.UserAuthServiceHolder;
import com.qiang.demomall.usercenter.domain.userauth.service.UserAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 用户认证应用服务类
 *
 * @author qiang
 * @date 2023-09-07 22:37:30
 */
@Slf4j
@Service
public class UserAuthApplicationService {

    @Autowired
    private UserAuthServiceHolder holder;

    /**
     * 用户名登录
     * @param userAuthDTO 认证信息
     * @return token信息
     */
    public SaTokenInfo login(UserAuthDTO userAuthDTO){

        UserAuthService userAuthService = holder.getService(userAuthDTO.getMode());

        return userAuthService.login(userAuthDTO);
    }
}
