package com.hameddalvand.taskmanager.InternetModule;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import java.net.InetAddress;

public class InternetChecker {
    InternetCheckReceiver internetCheckReceiver;
    Activity activity;
    public InternetChecker(Activity activity , InterFaceNetwork interFaceNetwork) {
        this.activity=activity;
        internetCheckReceiver = new InternetCheckReceiver() {
            @Override
            protected void onNetworkConnected() {
                interFaceNetwork.onNetworkConnected();
            }
            @Override
            protected void onNetworkDisConnected() {
                interFaceNetwork.onNetworkDisConnected();
            }
        };
        registerReceiver();

    }
    public void registerReceiver(){
        activity.registerReceiver(internetCheckReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

    }

    public void unRegisterReceiver(){
        activity.unregisterReceiver(internetCheckReceiver);

    }


    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public static boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }


}
