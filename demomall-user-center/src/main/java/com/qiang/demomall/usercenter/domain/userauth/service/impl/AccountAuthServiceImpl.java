package com.qiang.demomall.usercenter.domain.userauth.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.qiang.demomall.common.dto.usercenter.UserAuthDTO;
import com.qiang.demomall.common.enums.usercenter.UserAuthModeEnum;
import com.qiang.demomall.usercenter.domain.userauth.service.UserAuthService;
import com.qiang.demomall.usercenter.domain.userinfo.model.UserInfo;
import com.qiang.demomall.usercenter.repository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 用户认证领域服务类实现类
 *
 * @author qiang
 * @date 2023-09-07 22:53:06
 */
@Slf4j
@Service
public class AccountAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * 服务支持认证模式
     * @return
     */
    @Override
    public UserAuthModeEnum support() {
        return UserAuthModeEnum.AUTH_ACCOUNT;
    }

    /**
     * 登录
     * @param userAuthDTO 认证信息
     * @return token信息
     */
    @Override
    public SaTokenInfo login(UserAuthDTO userAuthDTO) {

        // 获取用户信息
        UserInfo userInfo = userInfoRepository.getUserInfo(userAuthDTO.getUserName(), userAuthDTO.getPassword());

        // 第1步，先登录上
        StpUtil.login(userInfo.getUid());

        // 第2步，获取 Token  相关参数
        return StpUtil.getTokenInfo();

    }


}
