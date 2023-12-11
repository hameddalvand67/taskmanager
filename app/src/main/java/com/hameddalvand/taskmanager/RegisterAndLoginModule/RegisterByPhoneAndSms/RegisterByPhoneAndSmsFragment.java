package com.hameddalvand.taskmanager.RegisterAndLoginModule.RegisterByPhoneAndSms;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androchef.happytimer.countdowntimer.DynamicCountDownView;
import com.hameddalvand.taskmanager.FrameManager.FrameManager;
import com.hameddalvand.taskmanager.FrameManager.InterfaceFrameManager;
import com.hameddalvand.taskmanager.TimerModule.InterFaceTimer;
import com.hameddalvand.taskmanager.TimerModule.Timer;
import com.hameddalvand.taskmanager.InterFaceMainActivity;
import com.hameddalvand.taskmanager.InternetModule.InterFaceNetwork;
import com.hameddalvand.taskmanager.InternetModule.InternetChecker;
import com.hameddalvand.taskmanager.R;
import com.hameddalvand.taskmanager.ValidatorModule.Validator;

public class RegisterByPhoneAndSmsFragment extends Fragment
        implements InterfaceRegisterByPhoneAndSms.RegisterByPhoneAndSmsFragmentInterFace, InterfaceFrameManager , InterFaceTimer, InterFaceNetwork {


    public Timer timer;
    public InterfaceRegisterByPhoneAndSms.RegisterByPhoneAndSmsPresentationInterFace registerByPhoneAndSmsPresentationInterFace;
    EditText phone;
    TextView timerTextView;
    Validator validator;
    String phoneNumber;
    FrameManager frameManager;

    LinearLayout mainFrame,waitForConnect,waitForResponse;
    Button btn_main,btn_notConnect,btn_notResponse;
    DynamicCountDownView dynamicCountDownView;

    InternetChecker internetChecker;

    final String PHONE="PHONE";

    InterFaceMainActivity interFaceMainActivity;
    public RegisterByPhoneAndSmsFragment(InterFaceMainActivity interFaceMainActivity) {
        this.interFaceMainActivity=interFaceMainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_login_by_phone_and_sms, container, false);

        phone = view.findViewById(R.id.phone);
        timerTextView = view.findViewById(R.id.timer);
        timerTextView.setText("");

        dynamicCountDownView= view.findViewById(R.id.dynamicCountDownView);
        timer=new Timer(dynamicCountDownView,10,this);

        btn_main = view.findViewById(R.id.btn_main);
        btn_notConnect = view.findViewById(R.id.btn_notConnect);
        btn_notResponse = view.findViewById(R.id.btn_notResponse);
        mainFrame=view.findViewById(R.id.mainFrame);
        waitForConnect=view.findViewById(R.id.waitForConnect);
        waitForResponse=view.findViewById(R.id.waitForResponse);



        internetChecker= new InternetChecker(this.getActivity(), this);

        validator= new Validator();


        frameManager =new FrameManager(mainFrame,waitForConnect,waitForResponse,btn_main,btn_notConnect,btn_notResponse,this);
        frameManager.showLayout(mainFrame);



        return view;
    }

    public void register(){
        validator.validDataModels.clear();
        phoneNumber= phone.getText().toString().trim();
        validator.validDataModels.add(
                validator.validation.phoneValidate(PHONE,phoneNumber));
        if (validator.isValid()){
            //isvalid
            if (internetChecker.isNetworkConnected()){
                //show loading view internal
                waitForResponse();

                registerByPhoneAndSmsPresentationInterFace = new RegisterByPhoneAndSmsPresentation(RegisterByPhoneAndSmsFragment.this);
                registerByPhoneAndSmsPresentationInterFace.loginByLocaleDb(phoneNumber);
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
        register();
    }

    @Override
    public void btnNotConnectOnclick() {


    }

    @Override
    public void btnNotResponseOnclick() {



    }

    @Override
    public void waitForResponse() {
        frameManager.waitForResponse();
        timer.initTimer(30);
        timer.start();

    }

    @Override
    public void getResponse(String state) {
        timer.stop();

        if (state.equals(RegisterByPhoneAndSmsPresentation.SEND_CODE)){

            frameManager.showLayout(mainFrame);
            //start fragment
            this.interFaceMainActivity.startLoginByCodeSmsFragment();

        }else if (state.equals(RegisterByPhoneAndSmsPresentation.WAIT_TIME)){

        }else if (state.equals(RegisterByPhoneAndSmsPresentation.TRY_AGAIN)){

        }



    }

    @Override
    public void pleaseWait() {
        timer.start();
    }

    @Override
    public void getRemainingTime(String remainingTime) {

    }

    @Override
    public void endTime() {

    }

    @Override
    public void onNetworkConnected() {

    }

    @Override
    public void onNetworkDisConnected() {

    }

    @Override
    public void registerReceiver() {

    }

    @Override
    public void unRegisterReceiver() {

    }
}