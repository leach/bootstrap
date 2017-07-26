package com.anythy.quicksign.service.impl;

import com.anythy.quicksign.entity.WXUser;
import com.anythy.quicksign.mapper.WXUserMapper;
import com.anythy.quicksign.service.QuickSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Leach on 0025 2017/7/25.
 */
@Service
public class QuickSignServiceImpl implements QuickSignService {
    @Autowired
    WXUserMapper wxUserMapper;

    @Override
    public int enter(WXUser wxUser) {
        return wxUserMapper.insertWXUserInfo(wxUser);
    }
}
