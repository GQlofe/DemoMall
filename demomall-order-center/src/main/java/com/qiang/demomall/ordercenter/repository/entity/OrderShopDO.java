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
 * 店铺订单表
 * </p>
 *
 * @author qiang
 * @since 2023-09-14
 */
@Getter
@Setter
@TableName("tb_order_shop")
public class OrderShopDO implements Serializable {

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
     * 总订单id
     */
    private Long totalOrderId;

    /**
     * 订单状态OrderStatusEnum：1已完成，2待支付，3待发货，4待收货，5已取消，6待退款，7已退款，8待退货，9已退货待退款，10已退货已退款
     */
    private Integer orderStatus;

    /**
     * 订单类型OrderTypeEnum：1普通订单，2秒杀订单，3折扣活动订单
     */
    private Integer orderType;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 支付金额
     */
    private BigDecimal payAmount;

    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;

    /**
     * 支付编号
     */
    private String payNo;

    /**
     * 支付方式PayTypeEnum：1微信，2支付宝
     */
    private Integer payType;

    /**
     * 下单时间
     */
    private LocalDateTime orderTime;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 订单来源OrderSourceTypeEnum：1PC订单，2app订单，3小程序订单
     */
    private Integer sourceType;

    /**
     * 取消原因OrderCancelTypeEnum：1自动取消，2用户取消
     */
    private Integer cancelReason;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
