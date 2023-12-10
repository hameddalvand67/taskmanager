package com.hameddalvand.taskmanager.DataModels.EntityModels;

import com.orm.SugarRecord;

public class ProgramEntity extends SugarRecord {

    ShareListEntity shareUser;
    String name;
    String title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ProgramEntity(ShareListEntity shareUser, String name, String title, boolean active) {
        this.shareUser = shareUser;
        this.name = name;
        this.title = title;
        this.active = active;
    }
}
