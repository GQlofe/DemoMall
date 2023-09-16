package com.qiang.demomall.ordercenter.api.dubbo;

import com.qiang.demomall.common.dto.ordercenter.OrderInfoDTO;
import com.qiang.demomall.common.dubboapi.ordercenter.OrderInfoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @description 订单信息服务提供者
 *
 * @author qiang
 * @date 2023-09-16 21:46:41
 */
@DubboService
public class OrderInfoServiceProvider implements OrderInfoService {

    @Override
    public OrderInfoDTO getOrderInfo(Long uid) {
        return OrderInfoDTO.builder().orderId(123L).productName("aaaaa").build();

    }
}
