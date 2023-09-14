package com.qiang.demomall.productcenter.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品sku价格表
 * </p>
 *
 * @author qiang
 * @since 2023-09-14
 */
@Getter
@Setter
@TableName("tb_product_sku_price")
public class ProductSkuPriceDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * skuid
     */
    private Long skuId;

    /**
     * 成本价
     */
    private BigDecimal costPrice;

    /**
     * 销售价
     */
    private BigDecimal salePrice;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
