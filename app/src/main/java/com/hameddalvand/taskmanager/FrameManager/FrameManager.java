package com.hameddalvand.taskmanager.FrameManager;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FrameManager implements View.OnClickListener {

    LinearLayout mainFrame,waitForConnect,waitForResponse;
    Button btn_main,btn_notConnect,btn_notResponse;
    public InterfaceFrameManager interfaceFrameManager;




    public FrameManager(LinearLayout mainFrame, LinearLayout waitForConnect, LinearLayout waitForResponse, Button btn_main, Button btn_notConnect, Button btn_notResponse,
                        InterfaceFrameManager interfaceFrameManager) {
        this.mainFrame = mainFrame;
        this.waitForConnect = waitForConnect;
        this.waitForResponse = waitForResponse;
        this.btn_main = btn_main;
        this.btn_notConnect = btn_notConnect;
        this.btn_notResponse = btn_notResponse;
        this.interfaceFrameManager=interfaceFrameManager;
        this.btn_main.setOnClickListener(this::onClick);
        this.btn_notConnect.setOnClickListener(this::onClick);
        this.btn_notResponse.setOnClickListener(this::onClick);
        btn_main.setEnabled(false);
        setActiveBtnResponse(false);


    }


    public void setActiveBtnResponse(Boolean activated){
        if (activated)
            this.btn_notResponse.setVisibility(View.VISIBLE);
        this.btn_notResponse.setVisibility(View.GONE);
    }

    public void showLayout(LinearLayout layout){
        mainFrame.setVisibility(View.GONE);
        waitForConnect.setVisibility(View.GONE);
        waitForResponse.setVisibility(View.GONE);
        layout.setVisibility(View.VISIBLE);
    }


    public void waitForResponse(){
        setActiveBtnResponse(false);
        showLayout(waitForResponse);
    }

    public void waitForConnect(){
        showLayout(waitForConnect);
    }

    public void mainFrame(){
        showLayout(mainFrame);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==this.btn_main.getId()){

            this.interfaceFrameManager.btnMainOnclick();

        }else if (v.getId()==this.btn_notConnect.getId()){

            this.interfaceFrameManager.btnNotConnectOnclick();
        }else if (v.getId()==this.btn_notResponse.getId()){
            this.interfaceFrameManager.btnNotResponseOnclick();

        }
    }
}
