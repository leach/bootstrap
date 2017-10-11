package com.anythy.Service.impl;

import com.anythy.Service.UserService;
import com.anythy.entity.User;
import com.anythy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Leach on 0010 2017/10/10.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    @Override
    public User findByUserName(String userName) {
        return mapper.findByUserName(userName);
    }
}
