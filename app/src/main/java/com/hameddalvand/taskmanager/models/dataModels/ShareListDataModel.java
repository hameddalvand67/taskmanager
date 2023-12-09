package com.hameddalvand.taskmanager.models.dataModels;

import com.orm.SugarRecord;

public class ShareListDataModel extends SugarRecord {
    ShareDataModel share;

    UserDataModel user;

    public ShareDataModel getShare() {
        return share;
    }

    public void setShare(ShareDataModel share) {
        this.share = share;
    }

    public UserDataModel getUser() {
        return user;
    }

    public void setUser(UserDataModel user) {
        this.user = user;
    }

    public ShareListDataModel(ShareDataModel share, UserDataModel user) {
        this.share = share;
        this.user = user;
    }
}
