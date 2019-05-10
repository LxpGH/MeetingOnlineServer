package com.example.lxp.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("address")
public class Address {
    @TableField("address_id")
    private int address_id;
    @TableField("address_sit")
    private int address_sit;
    @TableField("address_room")
    private int address_room;

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_sit(int address_sit) {
        this.address_sit = address_sit;
    }

    public int getAddress_sit() {
        return address_sit;
    }

    public int getAddress_room() {
        return address_room;
    }

    public void setAddress_room(int address_room) {
        this.address_room = address_room;
    }
}
