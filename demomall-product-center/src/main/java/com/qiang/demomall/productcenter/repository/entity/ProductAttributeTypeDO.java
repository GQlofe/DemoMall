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
 * 商品属性类型表
 * </p>
 *
 * @author qiang
 * @since 2023-09-14
 */
@Getter
@Setter
@TableName("tb_product_attribute_type")
public class ProductAttributeTypeDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品属性类型id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 属性类型名称
     */
    private String typeName;

    /**
     * 状态：1生效中，2未生效
     */
    private Integer status;

    /**
     * 是否删除：0否，1是
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
