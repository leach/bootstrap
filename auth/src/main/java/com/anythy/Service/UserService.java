package com.anythy.Service;

import com.anythy.entity.User;

/**
 * Created by Leach on 0010 2017/10/10.
 */
public interface UserService {

    User findByUserName(String userName);
}
