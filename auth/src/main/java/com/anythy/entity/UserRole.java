package com.anythy.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by Leach on 0010 2017/10/10.
 */
@EntityScan
public class UserRole {
    private int user_id;
    private int role_id;
    private String roleName;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

}
