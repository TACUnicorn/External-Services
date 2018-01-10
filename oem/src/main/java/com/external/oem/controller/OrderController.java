package com.external.oem.controller;

import com.external.oem.model.Order;
import com.external.oem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class OrderController {

    @Autowired
    public OrderService orderService;

    @GetMapping(value = "/oem", produces = {"application/json"})
    @ResponseBody
    public ArrayList<Order> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping(value = "/oem/order", produces = {"application/json"})
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
