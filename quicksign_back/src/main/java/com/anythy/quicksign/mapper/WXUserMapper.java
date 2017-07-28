package com.anythy.quicksign.mapper;

import com.anythy.quicksign.entity.WXUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Leach on 0021 2017/7/21.
 */
@Mapper
public interface WXUserMapper {

    @Insert("insert into wxuser(openId,nickName) values (#{openId}, #{nickName})")
    public int insertWXUserInfo(WXUser wxUser);
}
