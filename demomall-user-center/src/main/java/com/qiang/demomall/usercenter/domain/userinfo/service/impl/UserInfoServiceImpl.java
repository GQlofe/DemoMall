package com.qiang.demomall.usercenter.domain.userinfo.service.impl;

import com.qiang.demomall.common.dto.usercenter.UserInfoDTO;
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
}
