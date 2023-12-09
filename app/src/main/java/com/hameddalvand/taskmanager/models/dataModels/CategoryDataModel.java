package com.hameddalvand.taskmanager.models.dataModels;

import com.orm.SugarRecord;

public class CategoryDataModel extends SugarRecord {

ShareListDataModel shareUser;
String name;
boolean active;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CategoryDataModel(ShareListDataModel shareUser, String name, boolean active) {
        this.shareUser = shareUser;
        this.name = name;
        this.active = active;
    }
}


