package com.hameddalvand.taskmanager.DataModels.EntityModels;

import com.orm.SugarRecord;

public class CategoryActivitiesEntity extends SugarRecord {
    CategoryEntity category;
    ActivityEntity activity;
    boolean active;

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public ActivityEntity getActivity() {
        return activity;
    }

    public void setActivity(ActivityEntity activity) {
        this.activity = activity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CategoryActivitiesEntity(CategoryEntity category, ActivityEntity activity, boolean active) {
        this.category = category;
        this.activity = activity;
        this.active = active;
    }
}
