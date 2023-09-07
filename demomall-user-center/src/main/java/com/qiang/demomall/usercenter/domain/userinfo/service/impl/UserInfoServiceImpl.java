package com.qiang.demomall.usercenter.domain.userinfo.service.impl;

import com.qiang.demomall.common.dto.usercenter.UserInfoDTO;
import com.qiang.demomall.common.enums.ErrorCodeEnum;
import com.qiang.demomall.common.exceptions.usercenter.UserAuthException;
import com.qiang.demomall.usercenter.domain.userinfo.model.UserInfo;
import com.qiang.demomall.usercenter.domain.userinfo.service.UserInfoService;
import com.qiang.demomall.usercenter.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 用户服务实现类
 *
 * @author qiang
 * @date 2023-08-29 21:51:13
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * 获取用户信息
     * @param uid 用户id
     * @return 用户信息
     */
    @Override
    public UserInfoDTO getUserInfo(Long uid) {
        UserInfo userInfo = userInfoRepository.getUserInfo(uid);
        return userInfo.convertTo();
    }

    /**
     * 获取用户信息
     * @param userName 用户名
     * @param password 密码
     * @return 用户信息模型
     */
    @Override
    public UserInfo getUserInfo(String userName, String password) {

        UserInfo userInfo = userInfoRepository.getUserInfo(userName, password);
        if (userInfo == null){
            throw new UserAuthException(ErrorCodeEnum.ERROR_2001);
        }
        return userInfo;
    }
}
