package com.hameddalvand.taskmanager.DataModels.EntityModels;

import com.orm.SugarRecord;

public class CategoryEntity extends SugarRecord {

ShareListEntity shareUser;
String name;
boolean active;

    public ShareListEntity getShareUser() {
        return shareUser;
    }

    public void setShareUser(ShareListEntity shareUser) {
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

    public CategoryEntity(ShareListEntity shareUser, String name, boolean active) {
        this.shareUser = shareUser;
        this.name = name;
        this.active = active;
    }
}


