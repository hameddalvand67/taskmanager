package com.hameddalvand.taskmanager.models.dataModels;

import com.orm.SugarRecord;

public class ProgramDataModel  extends SugarRecord {

    ShareListDataModel shareUser;
    String name;
    String title;
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

    public ProgramDataModel(ShareListDataModel shareUser, String name, String title, boolean active) {
        this.shareUser = shareUser;
        this.name = name;
        this.title = title;
        this.active = active;
    }
}
