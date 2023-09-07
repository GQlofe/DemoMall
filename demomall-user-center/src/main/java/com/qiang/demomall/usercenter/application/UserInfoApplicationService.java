package com.qiang.demomall.usercenter.application;

import com.qiang.demomall.common.dto.usercenter.UserInfoDTO;
import com.qiang.demomall.usercenter.domain.userinfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 用户信息应用服务类
 *
 * @author qiang
 * @date 2023-08-31 22:32:57
 */
@Service
public class UserInfoApplicationService {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 获取用户信息
     * @param uid
     * @return
     */
    public UserInfoDTO getUserInfo(Long uid){

        return userInfoService.getUserInfo(uid);

    }
}
