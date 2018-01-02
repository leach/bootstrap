package com.anythy.wechat.Service;

import com.anythy.wechat.cofig.WechatConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WechatHandler {

    @Autowired
    WechatConfig wechatConfig;

    public void init(){

    }
}