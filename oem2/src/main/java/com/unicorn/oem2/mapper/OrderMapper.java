package com.unicorn.oem2.mapper;

import com.unicorn.oem2.model.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Mapper
@Service
public interface OrderMapper {
    @Select("insert into orders(material_id, num, price) values (#{materialId}, #{num}, #{price})")
    void add(Order order);

    @Select("select price from material where id = #{id}")
    int getMaterialPrice(@Param("id") int id);
}
