package com.qiang.demomall.usercenter.facade.feign;

import com.qiang.demomall.common.dto.ordercenter.OrderInfoDTO;
import com.qiang.demomall.common.request.ordercenter.CreateOrderReq;
import com.qiang.demomall.common.response.MallResponse;
import com.qiang.demomall.usercenter.facade.feign.config.OrderFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description 订单中心
 *
 * @author qiang
 * @date 2023-08-29 22:06:16
 */
@FeignClient(value = "demomall-ordercenter",configuration = OrderFeignConfiguration.class)
public interface OrderCenterFegin {


    @RequestMapping(value = "/mall/order/getOrderInfo/{orderId}",method = RequestMethod.GET)
    MallResponse<OrderInfoDTO> getOrderInfo(@PathVariable Long orderId);


    @RequestMapping(value = "/mall/order/createOrder",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
    MallResponse<OrderInfoDTO> createOrder(CreateOrderReq request);

}
