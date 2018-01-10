package com.external.components.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface ComponentsMapper {

    @Insert("INSERT INTO orders(c_id, num) VALUES(#{c_id}, #{num})")
    public int addOrder(@Param("c_id") int c_id,
                         @Param("num") int num);


}
