package com.unicorn.oem2.controller;

import com.unicorn.oem2.model.OrderList;
import com.unicorn.oem2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    public OrderService orderService;

    @GetMapping(value = "/oem", produces = {"application/xml"})
    @ResponseBody
    public OrderList getOrders() {
        return orderService.getOrders();
    }

    @PostMapping(value = "/oem/order", produces = {"application/xml"})
    public boolean postOrder(@RequestParam int productId, @RequestParam int num) {
        try {
            orderService.postOrder(productId, num);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
