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
 * sku订单表
 * </p>
 *
 * @author qiang
 * @since 2023-09-14
 */
@Getter
@Setter
@TableName("tb_order_sku")
public class OrderSkuDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * skuid
     */
    private Long skuId;

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
     * 订单金额
     */
    private BigDecimal subOrderAmount;

    /**
     * 支付金额
     */
    private BigDecimal payAmount;

    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;

    /**
     * 订单类型OrderTypeEnum：1普通订单，2秒杀订单，3折扣活动订单
     */
    private Integer orderType;

    /**
     * 下单时间
     */
    private LocalDateTime orderTime;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
