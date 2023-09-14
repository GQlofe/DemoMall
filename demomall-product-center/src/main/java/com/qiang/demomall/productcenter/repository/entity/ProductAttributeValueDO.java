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
 * 商品属性值表
 * </p>
 *
 * @author qiang
 * @since 2023-09-14
 */
@Getter
@Setter
@TableName("tb_product_attribute_value")
public class ProductAttributeValueDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品属性值id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 属性值名称
     */
    private String valueName;

    /**
     * 属性值编码
     */
    private String valueCode;

    /**
     * 属性id
     */
    private Integer attributeId;

    /**
     * 是否默认：0否，1是
     */
    private Integer isDefault;

    /**
     * 状态：1生效中，2未生效
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
