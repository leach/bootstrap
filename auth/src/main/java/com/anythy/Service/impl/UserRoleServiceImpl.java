package com.anythy.Service.impl;

import com.anythy.Service.UserRoleService;
import com.anythy.entity.UserRole;
import com.anythy.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Leach on 0010 2017/10/10.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleMapper mapper;

    @Override
    public List<UserRole> findByUserId(int userId) {
        return null;
    }
}
