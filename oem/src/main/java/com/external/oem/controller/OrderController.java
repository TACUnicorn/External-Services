package com.external.oem.controller;

import com.external.oem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    public OrderService orderService;

    @PostMapping(value = "/oem/order", produces = {"application/json"})
    public int postOrder(@RequestParam int materialId, @RequestParam int num) {
        try {
            return orderService.postOrder(materialId, num);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
