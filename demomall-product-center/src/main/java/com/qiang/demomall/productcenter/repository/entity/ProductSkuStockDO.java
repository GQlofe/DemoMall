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
 * 商品sku库存表
 * </p>
 *
 * @author qiang
 * @since 2023-09-14
 */
@Getter
@Setter
@TableName("tb_product_sku_stock")
public class ProductSkuStockDO implements Serializable {

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
     * sku现有库存
     */
    private Integer stock;

    /**
     * 预警库存
     */
    private Integer thresholdStock;

    /**
     * 下单锁定库存
     */
    private Integer lockStock;

    /**
     * 活动预占库存
     */
    private Integer occupyStock;

    /**
     * 总售卖数量
     */
    private Integer saleCount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
