package com.anythy.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Leach on 0010 2017/10/10.
 */
@EntityScan
public class User implements Serializable {
    private int id;
    private String openId;
    private String name;
    private String userName;
    private String password;
    private int gender;
    private String phone;
    private String email;
    private Date createTime;
    private int did;

    public User() {
    }

    public User(User user) {
        this.id = user.id;
        this.userName = user.userName;
        this.password = user.password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
}

