package com.hameddalvand.taskmanager.models.dataModels;

import com.orm.SugarRecord;

import java.util.List;

public class UserDataModel  extends SugarRecord {

    String phone;
    String firstname;
    String lastname;
    String token;
    String state;


    public List<CodeDataModel> getCodes(UserDataModel user) {
        return  CodeDataModel.find(CodeDataModel.class,
                "user = ?", String.valueOf(user.getId()));
    }




    public UserDataModel(String phone) {
        this.phone = phone;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}