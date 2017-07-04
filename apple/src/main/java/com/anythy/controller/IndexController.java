package com.anythy.controller;

import com.anythy.entity.Item;
import com.anythy.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Leach on 0026 2017/6/26.
 */
@RestController
public class IndexController {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    private ItemMapper itemMapper;
    @GetMapping("/dc")
    public String dc(){
        String services = "Services: " + discoveryClient.getServices();
        return services;
    }

    @GetMapping("/item")
    public List<Item> item(){
        return itemMapper.getAll();
    }
}
