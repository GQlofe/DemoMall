package com.qiang.demomall.gateway.feign;

import com.qiang.demomall.common.dto.ordercenter.OrderInfoDTO;
import com.qiang.demomall.common.request.usercenter.UserNameLoginReq;
import com.qiang.demomall.common.response.MallResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description 用户中心Feign
 *
 * @author qiang
 * @date 2023-09-09 21:30:56
 */
//@FeignClient(name = "user-center")
public interface UserCenterFeign {

    @RequestMapping(value = "/mall/user/auth/login/account",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
    MallResponse<OrderInfoDTO> loginByAccount(@RequestBody UserNameLoginReq req);



}
