package com.hameddalvand.taskmanager.DataModels.EntityModels;

import com.orm.SugarRecord;

public class CodeEntity extends SugarRecord {

    UserEntity user;
    String date_time;

    short count_request;

    String code;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public short getCount_request() {
        return count_request;
    }

    public void setCount_request(short count_request) {
        this.count_request = count_request;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CodeEntity(UserEntity user, String date_time, short count_request, String code) {
        this.user = user;
        this.date_time = date_time;
        this.count_request = count_request;
        this.code = code;
    }
}
