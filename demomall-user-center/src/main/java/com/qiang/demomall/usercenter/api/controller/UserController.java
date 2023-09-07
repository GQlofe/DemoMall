package com.qiang.demomall.usercenter.api.controller;

import com.qiang.demomall.common.dto.usercenter.UserInfoDTO;
import com.qiang.demomall.common.request.usercenter.UserInfoUidQueryReq;
import com.qiang.demomall.common.response.MallResponse;
import com.qiang.demomall.usercenter.application.UserInfoApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 用户控制器
 *
 * @author qiang
 * @date 2023-08-26 10:39:58
 */
@Slf4j
@Service
@RestController
public class UserController {


    @Autowired
    private UserInfoApplicationService applicationService;

    /**
     * 获取用户信息
     * @param req 请求对象
     * @return 用户信息
     */
    @PostMapping(value = "getUserInfo", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public MallResponse<UserInfoDTO> getUserInfo(@RequestBody @Validated UserInfoUidQueryReq req) {

        UserInfoDTO userInfoDTO = applicationService.getUserInfo(req.getUid());

        log.info(userInfoDTO.toString());
        return MallResponse.success(userInfoDTO);
    }
}
