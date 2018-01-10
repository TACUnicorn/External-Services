package com.unicorn.oem2.service;

import com.unicorn.oem2.mapper.OrderMapper;
import com.unicorn.oem2.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public int postOrder(int materialId, int num) {
        Order order = new Order();
        order.setMaterialId(materialId);
        order.setNum(num);
        order.setPrice(num * orderMapper.getMaterialPrice(materialId));
        orderMapper.add(order);
        return order.getPrice();
    }
}