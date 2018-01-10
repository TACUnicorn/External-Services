package com.external.bank.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Service
public interface BankMapper {

    @Select("select balance from account where id = #{id};")
    Float getBalance(@Param("id") String id);

    // 写成事务
    @Update("UPDATE account SET balance = balance + #{sum} WHERE id = #{id};")
    void addBalance(@Param("id") String id,
                        @Param("sum") Float sum);

    @Update("UPDATE account SET balance = balance - #{sum} WHERE id = #{id};")
    void reduceBalance(@Param("id") String id,
                        @Param("sum") Float sum);

//    @Transactional
//    public void change(String fromAcount, String toAcount, Float sum){
//
//    }
}
