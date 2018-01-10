package com.external.oem.service;

import com.external.oem.mapper.OrderMapper;
import com.external.oem.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public int postOrder(final int materialId, final int num) {
        Order order = new Order();
        order.setMaterialId(materialId);
        order.setNum(num);
        order.setPrice(num * orderMapper.getMaterialPrice(materialId));
        orderMapper.add(order);
        return order.getPrice();
    }
}


