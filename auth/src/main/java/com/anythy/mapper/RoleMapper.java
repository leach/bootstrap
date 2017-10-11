package com.anythy.mapper;

import com.anythy.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Leach on 0010 2017/10/10.
 */
@Mapper
public interface RoleMapper {

    @Select("SELECT id, `name`, createTime FROM role")
    Role findList();
}
