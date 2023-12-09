package com.hameddalvand.taskmanager.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hameddalvand.taskmanager.R;
import com.hameddalvand.taskmanager.interfaces.AppInterfaces;
import com.hameddalvand.taskmanager.models.NetWorkModel;
import com.hameddalvand.taskmanager.models.Validator.Validator;
import com.hameddalvand.taskmanager.presenters.LoginPresentation;

public class LoginFragment extends Fragment
        implements View.OnClickListener, AppInterfaces.loginFragmentInterFace{

    public AppInterfaces.loginPresentationInterFace loginPresentationInterFace;

    EditText phone;
    Button login;
    Validator validator;
    String phoneNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_login, container, false);
        phone = view.findViewById(R.id.phone);
        login = view.findViewById(R.id.login);

        login.setOnClickListener(this::onClick);


        validator= new Validator();


        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==login.getId()){
            //login click
            this.login();
        }

    }

    public void openLoading(){

    }

    public void openLoadingTryToConnectToInternet(){

    }
    public void  closeLoading(){

    }

    public void login(){
        phoneNumber= phone.getText().toString().trim();
        validator.validDataModels.add(
                validator.validation.phoneValidate(phoneNumber));
        if (validator.isValid()){
            //isvalid

            if (NetWorkModel.isNetworkConnected(this.getContext())){
                //show loading view internal
                openLoading();
                loginPresentationInterFace= new LoginPresentation(LoginFragment.this);
                loginPresentationInterFace.login(phoneNumber);
            }else {
                //show loading view internal
                openLoadingTryToConnectToInternet();

            }


        }else {
            // show error message
        }
    }


}