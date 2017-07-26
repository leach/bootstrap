package com.anythy.quicksign.service;

import com.anythy.quicksign.entity.WXUser;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Leach on 0025 2017/7/25.
 */
public interface QuickSignService {

    public int enter(WXUser wxUser);
}
