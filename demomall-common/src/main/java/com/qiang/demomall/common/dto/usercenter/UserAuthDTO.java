package com.qiang.demomall.common.dto.usercenter;

import com.qiang.demomall.common.enums.usercenter.UserAuthModeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 用户认证传输对象
 *
 * @author qiang
 * @date 2023-09-07 23:06:59
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthDTO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 认证模式
     */
    private UserAuthModeEnum mode;
}
