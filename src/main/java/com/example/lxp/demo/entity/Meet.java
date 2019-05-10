package com.example.lxp.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.sql.Date;

@TableName("meet")
public class Meet {
    @TableField("meet_id")
    private String meet_id;
    @TableField("meet_theme")
    private String meet_theme;
    @TableField("time_start")
    private Date time_start;
    @TableField("meet_room")
    private int meet_room;
    @TableField("time_end")
    private Date time_end;
    @TableField("meet_video")
    private String meet_video;
    @TableField("total_size")
    private int total_size;
    @TableField("true_size")
    private int true_size;
    @TableField("meet_summary")
    private String meet_summary;
    @TableField("host_user")
    private String host_user;
    @TableField("sit_num")
    private int sit_num;

    public void setMeet_id(String meet_id) {
        this.meet_id = meet_id;
    }

    public String getMeet_id() {
        return meet_id;
    }

    public void setMeet_theme(String meet_theme) {
        this.meet_theme = meet_theme;
    }

    public String getMeet_theme() {
        return meet_theme;
    }

    public void setTime_start(Date time_start) {
        this.time_start = time_start;
    }

    public Date getTime_start() {
        return time_start;
    }

    public void setMeet_room(int meet_room) {
        this.meet_room = meet_room;
    }

    public int getMeet_room() {
        return meet_room;
    }

    public void setTime_end(Date time_end) {
        this.time_end = time_end;
    }

    public Date getTime_end() {
        return time_end;
    }

    public void setMeet_video(String meet_video) {
        this.meet_video = meet_video;
    }

    public String getMeet_video() {
        return meet_video;
    }

    public void setTotal_size(int total_size) {
        this.total_size = total_size;
    }

    public int getTotal_size() {
        return total_size;
    }

    public void setTrue_size(int true_size) {
        this.true_size = true_size;
    }

    public int getTrue_size() {
        return true_size;
    }

    public void setMeet_summary(String meet_summary) {
        this.meet_summary = meet_summary;
    }

    public String getMeet_summary() {
        return meet_summary;
    }

    public void setHost_user(String host_user) {
        this.host_user = host_user;
    }

    public String getHost_user() {
        return host_user;
    }

    public void setSit_num(int sit_num) {
        this.sit_num = sit_num;
    }

    public int getSit_num() {
        return sit_num;
    }
}
