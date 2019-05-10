package com.example.lxp.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("user")
public class User {
@TableField("user_id")
    private String user_id;
@TableField("password")
    private String password;
@TableField
    private String user_name;
@TableField("head_url")
    private String head_url;

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }

    public String getHead_url() {
        return head_url;
    }
}
