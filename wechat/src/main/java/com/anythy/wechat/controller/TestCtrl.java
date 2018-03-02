package com.anythy.wechat.controller;

import io.goeasy.GoEasy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Leach on 0023 2018/2/23.
 */
@Controller("/")
public class TestCtrl {

    @RequestMapping("/page")
    public String page(){
        return "page";
    }

    @RequestMapping("/test")
    public void test(){
        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-7df4a7d1a2b5404e85226cfd28386250");
        goEasy.publish("demo_channel", "Hello world!");
    }
}
