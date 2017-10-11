package com.anythy.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

/**
 * Created by Leach on 0010 2017/10/10.
 */
@EntityScan
public class Role {
    private int id;
    private String name;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
