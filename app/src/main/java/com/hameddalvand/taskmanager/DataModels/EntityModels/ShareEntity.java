package com.hameddalvand.taskmanager.DataModels.EntityModels;

import com.orm.SugarRecord;

public class ShareEntity extends SugarRecord {

    UserEntity user;

    public ShareEntity(UserEntity user) {
        this.user = user;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
