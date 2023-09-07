package com.qiang.demomall.usercenter.repository.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiang.demomall.usercenter.repository.po.UserPO;
import com.qiang.demomall.usercenter.repository.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author qiang
 * @since 2023-08-29
 */
@Repository
public class UserDao extends ServiceImpl<UserMapper, UserPO> {

}
