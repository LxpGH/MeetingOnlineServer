package com.example.lxp.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.sql.Date;
import java.sql.Time;

@TableName("room")
public class Room {
    @TableField("room_id")
    private int room_id;
    @TableField("room_password")
    private String room_password;
    @TableField("room_name")
    private String room_name;
    @TableField( "room_head")
    private String room_head;
    @TableField("room_type")
    private int room_type;
    @TableField("room_size")
    private int room_size;
    @TableField("build_time")
    private Date build_time;
    @TableField("sit_host")
    private int sit_host;
    @TableField("sit_first")
    private int sit_first;
    @TableField("sit_second")
    private int sit_second;
    @TableField("sit_third")
    private int sit_third;
    @TableField("sit_fourth")
    private int sit_fourth;

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getRoom_name() {
        return room_name;
        }

    public void setRoom_password(String room_password) {
        this.room_password = room_password;
    }

    public String getRoom_password() {
        return room_password;
    }

    public void setRoom_head(String room_head) {
        this.room_head = room_head;
    }

    public String getRoom_head() {
        return room_head;
    }

    public void setRoom_type(int room_type) {
        this.room_type = room_type;
    }

    public int getRoom_type() {
        return room_type;
    }

    public void setRoom_size(int room_size) {
        this.room_size = room_size;
    }

    public int getRoom_size() {
        return room_size;
    }

    public void setBuild_time(Date build_time) {
        this.build_time = build_time;
    }

    public Date getBuild_time() {
        return build_time;
    }

    public void setSit_host(int sit_host) {
        this.sit_host = sit_host;
    }

    public int getSit_host() {
        return sit_host;
    }

    public void setSit_first(int sit_first) {
        this.sit_first = sit_first;
    }

    public int getSit_first() {
        return sit_first;
    }

    public void setSit_second(int sit_second) {
        this.sit_second = sit_second;
    }

    public int getSit_second() {
        return sit_second;
    }

    public void setSit_third(int sit_third) {
        this.sit_third = sit_third;
    }

    public int getSit_third() {
        return sit_third;
    }

    public void setSit_fourth(int sit_fourth) {
        this.sit_fourth = sit_fourth;
    }

    public int getSit_fourth() {
        return sit_fourth;
    }
}

