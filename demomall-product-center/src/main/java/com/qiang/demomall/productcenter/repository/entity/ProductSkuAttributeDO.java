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
 * 商品sku属性表
 * </p>
 *
 * @author qiang
 * @since 2023-09-14
 */
@Getter
@Setter
@TableName("tb_product_sku_attribute")
public class ProductSkuAttributeDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关联id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * skuid
     */
    private Long skuId;

    /**
     * 属性值id
     */
    private Long attributeValueId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
