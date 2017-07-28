package com.anythy.quicksign.mapper;

import com.anythy.quicksign.entity.WXUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Leach on 0021 2017/7/21.
 */
@Mapper
public interface WXUserMapper {

    @Insert("insert IGNORE into wxuser(openId,nickName) values (#{openId}, #{nickName})")
    public int insertWXUserInfo(WXUser wxUser);
}
