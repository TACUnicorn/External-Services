package com.external.oem.mapper;

import com.external.oem.model.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface OrderMapper {
    @Select("insert into orders(material_id, num, price) values (#{materialId}, #{num}, #{price})")
    void add(Order order);

    @Select("select price from material where id = #{id}")
    int getMaterialPrice(@Param("id") int id);
}
