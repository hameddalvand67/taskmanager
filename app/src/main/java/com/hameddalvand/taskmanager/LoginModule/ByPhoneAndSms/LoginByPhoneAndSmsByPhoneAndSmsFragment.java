package com.hameddalvand.taskmanager.LoginModule.ByPhoneAndSms;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hameddalvand.taskmanager.FrameManager.FrameManager;
import com.hameddalvand.taskmanager.FrameManager.InterfaceFrameManager;
import com.hameddalvand.taskmanager.R;
import com.hameddalvand.taskmanager.HelperModels.NetWorkModel;
import com.hameddalvand.taskmanager.HelperModels.Validator.Validator;

public class LoginByPhoneAndSmsByPhoneAndSmsFragment extends Fragment
        implements  InterfaceLoginByPhoneAndSms.LoginByPhoneAndSmsFragmentInterFace , InterfaceFrameManager {

    public InterfaceLoginByPhoneAndSms.LoginByPhoneAndSmsPresentationInterFace loginByPhoneAndSmsPresentationInterFace;

    EditText phone;

    Validator validator;
    String phoneNumber;
    FrameManager frameManager;

    LinearLayout mainFrame,waitForConnect,waitForResponse;
    Button btn_main,btn_notConnect,btn_notResponse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_login_by_phone_and_sms, container, false);
        phone = view.findViewById(R.id.phone);

        btn_main = view.findViewById(R.id.btn_main);
        btn_notConnect = view.findViewById(R.id.btn_notConnect);
        btn_notResponse = view.findViewById(R.id.btn_notResponse);
        mainFrame=view.findViewById(R.id.mainFrame);
        waitForConnect=view.findViewById(R.id.waitForConnect);
        waitForResponse=view.findViewById(R.id.waitForResponse);



        validator= new Validator();


        frameManager =new FrameManager(mainFrame,waitForConnect,waitForResponse,btn_main,btn_notConnect,btn_notResponse,this);
        frameManager.showLayout(mainFrame);



        return view;
    }

    public void login(){
        validator.validDataModels.clear();
        phoneNumber= phone.getText().toString().trim();
        validator.validDataModels.add(
                validator.validation.phoneValidate(phoneNumber));
        if (validator.isValid()){
            //isvalid
            if (NetWorkModel.isNetworkConnected(this.getContext())){
                //show loading view internal
                frameManager.waitForResponse();

                loginByPhoneAndSmsPresentationInterFace = new LoginByPhoneAndSmsLoginByPhoneAndSmsPresentation(LoginByPhoneAndSmsByPhoneAndSmsFragment.this);
                loginByPhoneAndSmsPresentationInterFace.loginByLocaleDb(phoneNumber);
            }else {
                //show loading view internal
                frameManager.waitForConnect();

            }


        }else {
            frameManager.mainFrame();
            // show error message
            Toast.makeText(this.getContext(), "err", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void btnMainOnclick() {
        login();
    }

    @Override
    public void btnNotConnectOnclick() {


    }

    @Override
    public void btnNotResponseOnclick() {



    }

    @Override
    public void getResponse(String state) {

    }
}