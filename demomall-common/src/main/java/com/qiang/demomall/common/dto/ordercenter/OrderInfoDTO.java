package com.qiang.demomall.common.dto.ordercenter;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * @description 订单信息
 *
 * @author qiang
 * @date 2023-08-29 22:08:29
 */
@Data
@Builder
@ToString
public class OrderInfoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    private Long orderId;

    private String productName;

}
