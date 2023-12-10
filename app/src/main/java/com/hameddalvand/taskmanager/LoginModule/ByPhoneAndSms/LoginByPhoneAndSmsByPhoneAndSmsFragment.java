package com.hameddalvand.taskmanager.LoginModule.ByPhoneAndSms;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hameddalvand.taskmanager.R;
import com.hameddalvand.taskmanager.HelperModels.NetWorkModel;
import com.hameddalvand.taskmanager.HelperModels.Validator.Validator;

public class LoginByPhoneAndSmsByPhoneAndSmsFragment extends Fragment
        implements View.OnClickListener, InterfaceLoginByPhoneAndSms.LoginByPhoneAndSmsFragmentInterFace {

    public InterfaceLoginByPhoneAndSms.LoginByPhoneAndSmsPresentationInterFace loginByPhoneAndSmsPresentationInterFace;

    EditText phone;
    Button login;
    Validator validator;
    String phoneNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_login_by_phone_and_sms, container, false);
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
                loginByPhoneAndSmsPresentationInterFace = new LoginByPhoneAndSmsLoginByPhoneAndSmsPresentation(LoginByPhoneAndSmsByPhoneAndSmsFragment.this);
                loginByPhoneAndSmsPresentationInterFace.loginByLocaleDb(phoneNumber);
            }else {
                //show loading view internal
                openLoadingTryToConnectToInternet();

            }


        }else {
            // show error message
        }
    }


}