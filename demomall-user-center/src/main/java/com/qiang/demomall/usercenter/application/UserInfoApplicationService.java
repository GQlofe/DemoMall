package com.qiang.demomall.usercenter.application;

import com.qiang.demomall.common.dto.ordercenter.OrderInfoDTO;
import com.qiang.demomall.common.dto.usercenter.UserInfoDTO;
import com.qiang.demomall.common.dubboapi.ordercenter.OrderInfoService;
import com.qiang.demomall.usercenter.domain.userinfo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 用户信息应用服务类
 *
 * @author qiang
 * @date 2023-08-31 22:32:57
 */
@Slf4j
@Service
public class UserInfoApplicationService {

    @Autowired
    private UserInfoService userInfoService;

    @DubboReference
    private OrderInfoService orderInfoService;

    /**
     * 获取用户信息
     * @param uid
     * @return
     */
    public UserInfoDTO getUserInfo(Long uid){
        UserInfoDTO userInfo = userInfoService.getUserInfo(uid);
        OrderInfoDTO orderInfo = orderInfoService.getOrderInfo(userInfo.getUid());

        log.info("dubbo orderInfo={}",orderInfo.toString());
        return userInfo;

    }
}
