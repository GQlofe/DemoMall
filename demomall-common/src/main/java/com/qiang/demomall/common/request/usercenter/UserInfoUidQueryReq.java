package com.qiang.demomall.common.request.usercenter;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * @description 用户信息uid查询请求对象
 *
 * @author qiang
 * @date 2023-09-02 11:30:25
 */
@Data
public class UserInfoUidQueryReq {

    @NotNull(message = "用户id不能为空")
    private Long uid;
}
