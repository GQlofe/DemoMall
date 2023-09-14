package com.qiang.demomall.ordercenter.api.controller;

import com.qiang.demomall.common.dto.ordercenter.OrderInfoDTO;
import com.qiang.demomall.common.request.ordercenter.CreateOrderReq;
import com.qiang.demomall.common.response.MallResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @description 订单控制器
 *
 * @author qiang
 * @date 2023-08-29 22:17:05
 */
@Slf4j
@RestController
public class OrderController {

    @RequestMapping(value = "getOrderInfo/{orderId}", method = RequestMethod.GET)
    public MallResponse<OrderInfoDTO> getOrderInfo(@PathVariable Long orderId) {


        log.info("orderId={}", orderId);
        OrderInfoDTO orderInfo = OrderInfoDTO.builder().orderId(2000L).productName("矿泉水").build();

        return MallResponse.success(orderInfo);

    }


    @RequestMapping(value = "createOrder", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public MallResponse<OrderInfoDTO> createOrder(@RequestBody CreateOrderReq req) {
        log.info("req={}", req.toString());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        OrderInfoDTO orderInfo = OrderInfoDTO.builder().orderId(2000L).productName("达拉斯加").build();

        return MallResponse.success(orderInfo);

    }
}
