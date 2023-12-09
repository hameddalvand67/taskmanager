package com.hameddalvand.taskmanager.models.dataModels;

import com.orm.SugarRecord;

public class ToDoListDataModel  extends SugarRecord {

    ProgramActivitiesDataModel programActivities;
    String time;
    String doing;
    String date;

}
