package com.unicorn.oem2.controller;

import com.unicorn.oem2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    public OrderService orderService;

    @PostMapping(value = "/oem/order", produces = {"application/xml"})
    public int postOrder(@RequestParam int materialId, @RequestParam int num) {
        try {
            return orderService.postOrder(materialId, num);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
