package com.hameddalvand.taskmanager.models.dataModels;

import com.orm.SugarRecord;

public class CategoryActivitiesDataModel  extends SugarRecord {
    CategoryDataModel category;
    ActivityDataModel activity;
    boolean active;

    public CategoryDataModel getCategory() {
        return category;
    }

    public void setCategory(CategoryDataModel category) {
        this.category = category;
    }

    public ActivityDataModel getActivity() {
        return activity;
    }

    public void setActivity(ActivityDataModel activity) {
        this.activity = activity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CategoryActivitiesDataModel(CategoryDataModel category, ActivityDataModel activity, boolean active) {
        this.category = category;
        this.activity = activity;
        this.active = active;
    }
}
