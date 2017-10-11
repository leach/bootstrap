package com.anythy.userDetails;

import com.anythy.Service.UserRoleService;
import com.anythy.Service.UserService;
import com.anythy.entity.User;
import com.anythy.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Leach on 0010 2017/10/10.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user;
        try {
            user = userService.findByUserName(userName);
        }catch (Exception e){
            throw new UsernameNotFoundException("select user faild.");
        }
        if(user == null){
            throw new UsernameNotFoundException("user not found.");
        }
        try {
            List<UserRole> roles = userRoleService.findByUserId(user.getId());
            return new CustomUserDetails(user, roles);
        }catch (Exception e){
            throw new UsernameNotFoundException("user role not found.");
        }
    }
}
