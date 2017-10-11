package com.anythy.Service;

import com.anythy.entity.UserRole;

import java.util.List;

/**
 * Created by Leach on 0010 2017/10/10.
 */
public interface UserRoleService {

    List<UserRole> findByUserId(int userId);
}
