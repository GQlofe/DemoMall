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
 * 总订单表
 * </p>
 *
 * @author qiang
 * @since 2023-09-14
 */
@Getter
@Setter
@TableName("tb_order_parent")
public class OrderParentDO implements Serializable {

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
     * 总订单状态TotalOrderStatusEnum：1待支付，2已完成，3已取消
     */
    private Integer totalOrderStatus;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 支付总金额
     */
    private BigDecimal payAmount;

    /**
     * 总优惠金额
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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
