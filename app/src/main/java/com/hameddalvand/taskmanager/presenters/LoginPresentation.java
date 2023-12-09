package com.hameddalvand.taskmanager.presenters;

import com.hameddalvand.taskmanager.interfaces.AppInterfaces;
import com.hameddalvand.taskmanager.models.AppModels.LoginModels;
import com.hameddalvand.taskmanager.models.NetWorkModel;
import com.hameddalvand.taskmanager.views.LoginFragment;

public class LoginPresentation implements AppInterfaces.loginPresentationInterFace {
    AppInterfaces.loginFragmentInterFace loginFragmentInterFace;
    AppInterfaces.loginModelInterFace loginModelInterFace;


    public LoginPresentation(AppInterfaces.loginFragmentInterFace loginFragmentInterFace) {
        this.loginFragmentInterFace=loginFragmentInterFace;

    }

    @Override
    public void login(String phoneNumber) {

        loginModelInterFace= new LoginModels(this);
        loginModelInterFace.loginLocaleDb(phoneNumber);

    }
}
