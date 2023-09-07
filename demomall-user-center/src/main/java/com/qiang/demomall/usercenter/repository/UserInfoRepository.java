package com.qiang.demomall.usercenter.repository;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.qiang.demomall.usercenter.domain.userinfo.model.UserInfo;
import com.qiang.demomall.usercenter.repository.dao.UserDao;
import com.qiang.demomall.usercenter.repository.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @description 用户信息存储类
 *
 * @author qiang
 * @date 2023-09-02 09:55:32
 */
@Slf4j
@Repository
public class UserInfoRepository {

    @Autowired
    private UserDao userDao;


    /**
     * 获取用户信息领域对象
     * @param uid 用户id
     * @return 用户信息领域对象
     */
    public UserInfo getUserInfo(Long uid) {

        UserPO userPO = userDao.getById(uid);

        UserInfo userInfo = UserInfo.from(userPO);

        return userInfo;

    }

    /**
     * 获取用户信息模型
     * @param userName 用户名
     * @param password 密码
     * @return 用户信息
     */
    public UserInfo getUserInfo(String userName, String password) {

        LambdaQueryChainWrapper<UserPO> query = userDao.lambdaQuery()
                .eq(UserPO::getUserName, userName)
                .eq(UserPO::getPassword, password);

        Optional<UserPO> opt = query.oneOpt();

        if (opt.isEmpty()) {
            log.info("用户信息不存在，userName={}", userName);
            return null;
        }

        UserPO userPO = opt.get();

        return UserInfo.from(userPO);
    }
}
