package com.external.oem.service;

import com.external.oem.mapper.OrderMapper;
import com.external.oem.model.Order;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    public ArrayList<Order> getOrders() {
        return orderMapper.getOrders();
    }

    public void postOrder(final int productId, final int num) {
        String fromAccount = "TAC Inc";
        String toAccount = "Foxconn Technology Group";

        Order order = new Order();
        order.setProductId(productId);
        order.setNum(num);
        order.setPrice(num * orderMapper.getProduct(productId));
        if (transfer(fromAccount, toAccount, order.getPrice())) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    putWarehouse(productId, num);
                }
            }).start();
        }
        orderMapper.add(order);

    }

    public void putWarehouse(int id, int num) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        String content = "{\"id\":"+ id +
                ",\"num\":" + num + "}";
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"), content);
        Request request = new Request.Builder()
                .url("http://10.0.1.52:8080/warehouse/put")
                .header("Content-Type", "application/json")
                .post(requestBody)
                .build();
        Call call = mOkHttpClient.newCall(request);

        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean transfer(String fromAccount, String toAccount, int price) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        String content = "{\"fromAccount\":\""+ fromAccount +
                "\",\"toAccount\":\"" + toAccount + "\", \"sum\":" + price + "}";
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"), content);
        Request request = new Request.Builder()
                .url("http://10.0.1.52:8080/finance/transfer")
                .header("Content-Type", "application/json")
                .post(requestBody)
                .build();
        Call call = mOkHttpClient.newCall(request);

        try {
            Response response = call.execute();
            System.out.println(response.body().string());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}


