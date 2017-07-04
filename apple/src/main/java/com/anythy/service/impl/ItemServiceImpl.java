package com.anythy.service.impl;

import com.anythy.entity.Item;
import com.anythy.mapper.ItemMapper;
import com.anythy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Leach on 0004 2017/7/4.
 */
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemMapper itemMapper;

    @Override
    public List<Item> getAll() {
        return itemMapper.getAll();
    }
}
