package com.anythy.mapper;

import com.anythy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Leach on 0010 2017/10/10.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT id,openId,`name`,userName,`password`,gender,phone,email,createTime,department_id " +
            "FROM `user` WHERE userName = #{userName}")
    User findByUserName(String userName);

}
