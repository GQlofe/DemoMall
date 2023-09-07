package com.qiang.demomall.common.request.ordercenter;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @description 创建订单请求实体
 *
 * @author qiang
 * @date 2023-08-29 22:32:54
 */
@Data
@Builder
@ToString
public class CreateOrderReq {

    private String productName;

    private int count;
}
