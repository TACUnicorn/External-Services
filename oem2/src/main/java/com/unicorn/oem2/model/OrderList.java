package com.unicorn.oem2.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

public class OrderList {
    @XmlElement(required = true)
    public ArrayList<Order> orders;

    public OrderList() {
    }

    public OrderList(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
