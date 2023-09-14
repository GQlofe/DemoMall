package com.qiang.demomall.productcenter.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品sku表
 * </p>
 *
 * @author qiang
 * @since 2023-09-14
 */
@Getter
@Setter
@TableName("tb_product_sku")
public class ProductSkuDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * skuid
     */
    @TableId(value = "sku_id", type = IdType.AUTO)
    private Long skuId;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * sku描述
     */
    private String description;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * spuid
     */
    private Long spuId;

    /**
     * 状态 1.未上架 2.已上架 3.已下架
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remark;

    /**
     * 图片地址
     */
    private String picUrl;

    /**
     * 是否删除：0否，1是
     */
    private Integer isDelete;

    /**
     * 创建人id
     */
    private Integer creator;

    /**
     * 修改人id
     */
    private Integer modifier;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
