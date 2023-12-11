package com.hameddalvand.taskmanager.InternetModule;

public interface InterFaceNetwork {

    void onNetworkConnected();
    void onNetworkDisConnected();
    void registerReceiver();
    void unRegisterReceiver();

}
