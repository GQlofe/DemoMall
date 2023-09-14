package com.qiang.demomall.shopcenter.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 店铺表
 * </p>
 *
 * @author qiang
 * @since 2023-09-14
 */
@Getter
@Setter
@TableName("tb_shop")
public class ShopDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 店铺id
     */
    @TableId(value = "shop_id", type = IdType.AUTO)
    private Long shopId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 手机号
     */
    private String phoneNum;

    /**
     * 店铺类型ShopTypeEnum：1普通店铺，2自营店铺
     */
    private Integer shopType;

    /**
     * 图片地址
     */
    private String picUrl;

    /**
     * 店铺简介
     */
    private String introduction;

    /**
     * 开店时间
     */
    private LocalDateTime registerTime;

    /**
     * 店铺地址
     */
    private String address;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
