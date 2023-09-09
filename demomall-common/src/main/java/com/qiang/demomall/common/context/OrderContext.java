package com.qiang.demomall.common.context;

import lombok.Builder;
import lombok.Data;

/**
 * @description 订单线程本地上下文
 *
 * @author qiang
 * @date 2023-09-10 01:21:52
 */
@Data
@Builder
public class OrderContext implements LocalContext{

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 订单id
     */
    private Long orderId;
}
