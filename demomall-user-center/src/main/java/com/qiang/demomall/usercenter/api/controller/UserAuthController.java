package com.qiang.demomall.usercenter.api.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.qiang.demomall.common.dto.usercenter.UserAuthDTO;
import com.qiang.demomall.common.enums.usercenter.UserAuthModeEnum;
import com.qiang.demomall.common.request.usercenter.UserNameLoginReq;
import com.qiang.demomall.common.response.MallResponse;
import com.qiang.demomall.usercenter.application.UserAuthApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 用户认证控制器
 *
 * @author qiang
 * @date 2023-09-07 22:35:13
 */
@Slf4j
@RestController
@RequestMapping("auth")
public class UserAuthController {

    @Autowired
    private UserAuthApplicationService applicationService;


    /**
     * 获取用户信息
     * @param req 请求对象
     * @return 用户信息
     */
    @PostMapping(value = "login/account", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public MallResponse<SaTokenInfo> loginByAccount(@RequestBody @Validated UserNameLoginReq req) {

        UserAuthDTO userAuthDTO = new UserAuthDTO();
        BeanUtils.copyProperties(req,userAuthDTO);

        // 设置认证模式
        userAuthDTO.setMode(UserAuthModeEnum.AUTH_ACCOUNT);

        // 登录
        SaTokenInfo token = applicationService.login(userAuthDTO);

        return MallResponse.success(token);
    }



}
