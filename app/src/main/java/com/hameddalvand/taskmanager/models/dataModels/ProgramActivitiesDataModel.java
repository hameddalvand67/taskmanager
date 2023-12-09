package com.hameddalvand.taskmanager.models.dataModels;

import com.orm.SugarRecord;

public class ProgramActivitiesDataModel  extends SugarRecord {

    ActivityDataModel activity;
    ProgramDataModel program;
    String  time;
    String  startDate;
    String  endDate;

    public ActivityDataModel getActivity() {
        return activity;
    }

    public void setActivity(ActivityDataModel activity) {
        this.activity = activity;
    }

    public ProgramDataModel getProgram() {
        return program;
    }

    public void setProgram(ProgramDataModel program) {
        this.program = program;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ProgramActivitiesDataModel(ActivityDataModel activity, ProgramDataModel program, String time, String startDate, String endDate) {
        this.activity = activity;
        this.program = program;
        this.time = time;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
