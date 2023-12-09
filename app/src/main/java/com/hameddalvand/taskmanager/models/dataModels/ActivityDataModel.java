package com.hameddalvand.taskmanager.models.dataModels;

import com.orm.SugarRecord;

public class ActivityDataModel extends SugarRecord {
    ShareListDataModel shareUser;
    String name;
    long value;
    String description;
    String created_at;
    String dead_line;
    String time;
    String state;
    ActivityDataModel activity;

    public ShareListDataModel getShareUser() {
        return shareUser;
    }

    public void setShareUser(ShareListDataModel shareUser) {
        this.shareUser = shareUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDead_line() {
        return dead_line;
    }

    public void setDead_line(String dead_line) {
        this.dead_line = dead_line;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ActivityDataModel getActivity() {
        return activity;
    }

    public void setActivity(ActivityDataModel activity) {
        this.activity = activity;
    }

    public ActivityDataModel(ShareListDataModel shareUser, String name, long value, String description, String created_at, String dead_line, String time, String state, ActivityDataModel activity) {
        this.shareUser = shareUser;
        this.name = name;
        this.value = value;
        this.description = description;
        this.created_at = created_at;
        this.dead_line = dead_line;
        this.time = time;
        this.state = state;
        this.activity = activity;
    }
}
