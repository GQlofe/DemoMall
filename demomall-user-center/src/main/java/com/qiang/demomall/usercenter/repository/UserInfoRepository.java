package com.qiang.demomall.usercenter.repository;

import com.qiang.demomall.usercenter.domain.userinfo.model.UserInfo;
import com.qiang.demomall.usercenter.repository.dao.UserDao;
import com.qiang.demomall.usercenter.repository.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
