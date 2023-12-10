package com.hameddalvand.taskmanager.DataModels.EntityModels;

import com.orm.SugarRecord;

public class ShareListEntity extends SugarRecord {
    ShareEntity share;

    UserEntity user;

    public ShareEntity getShare() {
        return share;
    }

    public void setShare(ShareEntity share) {
        this.share = share;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ShareListEntity(ShareEntity share, UserEntity user) {
        this.share = share;
        this.user = user;
    }
}
