package com.hameddalvand.taskmanager.models.dataModels;

import com.orm.SugarRecord;

public class ShareDataModel extends SugarRecord {

    UserDataModel user;

    public ShareDataModel(UserDataModel user) {
        this.user = user;
    }

    public UserDataModel getUser() {
        return user;
    }

    public void setUser(UserDataModel user) {
        this.user = user;
    }
}
