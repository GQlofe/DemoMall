package com.qiang.demomall.common.dubboapi.ordercenter;

import com.qiang.demomall.common.dto.ordercenter.OrderInfoDTO;

/**
 * @description 订单信息接口
 *
 * @author qiang
 * @date 2023-09-16 21:35:40
 */
public interface OrderInfoService {

    OrderInfoDTO getOrderInfo(Long uid);
}
