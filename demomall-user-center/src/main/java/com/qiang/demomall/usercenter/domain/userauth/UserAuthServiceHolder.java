package com.qiang.demomall.usercenter.domain.userauth;

import com.qiang.demomall.common.enums.usercenter.UserAuthModeEnum;
import com.qiang.demomall.usercenter.domain.userauth.service.UserAuthService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 用户认证服务持有类
 *
 * @author qiang
 * @date 2023-09-08 00:00:48
 */
@Component
public class UserAuthServiceHolder implements InitializingBean {

    private final Map<UserAuthModeEnum, UserAuthService> services = new HashMap<>();

    @Autowired
    private List<UserAuthService> list;

    @Override
    public void afterPropertiesSet() throws Exception {
        list.forEach(service -> services.put(service.support(), service));
    }

    /**
     * 获取指定模式的认证服务类
     * @param mode 认证模式
     * @return 服务类
     */
    public UserAuthService getService(UserAuthModeEnum mode) {

        return services.get(mode);
    }
}
