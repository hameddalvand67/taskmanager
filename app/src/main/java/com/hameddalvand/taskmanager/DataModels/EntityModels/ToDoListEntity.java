package com.hameddalvand.taskmanager.DataModels.EntityModels;

import com.orm.SugarRecord;

public class ToDoListEntity extends SugarRecord {

    ProgramActivitiesEntity programActivities;
    String time;
    String doing;
    String date;

}
