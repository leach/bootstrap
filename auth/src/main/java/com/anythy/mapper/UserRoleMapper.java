package com.anythy.mapper;

import com.anythy.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Leach on 0010 2017/10/10.
 */
@Mapper
public interface UserRoleMapper {

    @Select("SELECT user_id, role_id, name as roleName FROM user_role " +
            "INNER JOIN role ON id = role_id WHERE user_id = #{userId}")
    List<UserRole> findByUserId(int userId);
}
