package com.qiang.demomall.usercenter.domain.userinfo.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.qiang.demomall.common.dto.usercenter.UserInfoDTO;
import com.qiang.demomall.usercenter.repository.entity.UserDO;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description 用户信息模型
 *
 * @author qiang
 * @date 2023-09-02 10:10:30
 */
@Data
public class UserInfo {

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号
     */
    private String phoneNum;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别：male,female
     */
    private String sex;

    /**
     * 生日
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime birthday;

    /**
     * 创建时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;


    // json工具对象
    private static final ObjectMapper objectResolver = new ObjectMapper();



    /**
     * 通过持久化对象创建领域对象
     * @param userDO 持久化对象
     * @return 领域对象
     */
    public static UserInfo from(UserDO userDO) {
        UserInfo userInfo = objectResolver.convertValue(userDO, UserInfo.class);

        return userInfo;
    }


    /**
     * 转换成dto
     * @return UserInfoDTO
     */
    public UserInfoDTO convertTo() {

        return objectResolver.convertValue(this, UserInfoDTO.class);
    }
}
