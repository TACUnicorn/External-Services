package com.external.oem.mapper;

import com.external.oem.model.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Mapper
@Service
public interface OrderMapper {
    @Select("select * from orders;")
    @Results({
            @Result(property = "productId", column = "p_id")
    })
    ArrayList<Order> getOrders();

    @Select("insert into orders(p_id, num) values (#{productId}, #{num})")
    void add(Order order);

    @Select("select price from material where id = #{id}")
    int getProduct(@Param("id") int id);
}
