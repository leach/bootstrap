package com.anythy.mapper;

import com.anythy.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Leach on 0029 2017/6/29.
 */
@Mapper
public interface ItemMapper {
        List<Item> getAll();
}
