package com.external.express.mapper;

import com.external.express.model.Express;
import com.external.express.model.ExpressTmp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Create by xuantang
 * @date on 1/10/18
 */
@Service
@Mapper
public interface ExpressMapper {

    @Insert("INSERT INTO express(toUser, toUserPhone, fromUser, fromUserPhone," +
            "source, destination, time) VALUES(#{toUser}, #{toUserPhone}, #{fromUser}, " +
            "#{fromUserPhone}, #{source}, #{destination}, now())")
    int addExpress(ExpressTmp expressTmp);

    @Select("SELECT toUser, toUserPhone, fromUser, fromUserPhone," +
            "source, destination, time FROM express ORDER BY time DESC")
    List<Express> getExpresses();
}
