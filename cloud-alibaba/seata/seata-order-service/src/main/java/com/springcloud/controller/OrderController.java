package com.springcloud.controller;

import com.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/order/")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 模拟创建订单
     * @param productId
     * @param price
     * @return
     */
    @PostMapping("/create")
    public String create(Long productId, BigDecimal price){
        try {
            orderService.createOrder(productId, price);
        } catch (Exception e) {
            log.error("order failed: ", e);
            return "order failed";
        }
        return "order success";
    }

}
