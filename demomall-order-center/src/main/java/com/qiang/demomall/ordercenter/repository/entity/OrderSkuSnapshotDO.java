package com.qiang.demomall.ordercenter.repository.entity;

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
 * 子订单sku快照表
 * </p>
 *
 * @author qiang
 * @since 2023-09-14
 */
@Getter
@Setter
@TableName("tb_order_sku_snapshot")
public class OrderSkuSnapshotDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 子订单id
     */
    private Long subOrderId;

    /**
     * skuid
     */
    private Long skuId;

    /**
     * skuid
     */
    private String skuName;

    /**
     * 描述
     */
    private String description;

    /**
     * sku数量
     */
    private Long skuCount;

    /**
     * sku成本单价
     */
    private BigDecimal costPrice;

    /**
     * sku销售单价
     */
    private BigDecimal salePrice;

    /**
     * sku图片地址
     */
    private String picUrl;

    /**
     * 属性
     */
    private String attributes;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
