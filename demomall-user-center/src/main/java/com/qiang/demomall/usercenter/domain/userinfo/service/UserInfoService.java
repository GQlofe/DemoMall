package com.qiang.demomall.usercenter.domain.userinfo.service;

import com.qiang.demomall.common.dto.usercenter.UserInfoDTO;
import com.qiang.demomall.usercenter.domain.userinfo.model.UserInfo;

/**
 * @description 用户服务类
 *
 * @author qiang
 * @date 2023-08-29 21:50:30
 */
public interface UserInfoService {

    /**
     * 获取用户信息
     * @param uid 用户id
     * @return 用户信息
     */
    UserInfoDTO getUserInfo(Long uid);

    /**
     * 获取用户信息
     * @param userName 用户名
     * @param password 密码
     * @return 用户信息模型
     */
    UserInfo getUserInfo(String userName, String password);
}
