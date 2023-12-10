package com.hameddalvand.taskmanager.DataModels.EntityModels;

import com.orm.SugarRecord;

public class ProgramActivitiesEntity extends SugarRecord {

    ActivityEntity activity;
    ProgramEntity program;
    String  time;
    String  startDate;
    String  endDate;

    public ActivityEntity getActivity() {
        return activity;
    }

    public void setActivity(ActivityEntity activity) {
        this.activity = activity;
    }

    public ProgramEntity getProgram() {
        return program;
    }

    public void setProgram(ProgramEntity program) {
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

    public ProgramActivitiesEntity(ActivityEntity activity, ProgramEntity program, String time, String startDate, String endDate) {
        this.activity = activity;
        this.program = program;
        this.time = time;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
