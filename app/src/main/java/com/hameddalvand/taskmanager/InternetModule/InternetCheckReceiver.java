package com.hameddalvand.taskmanager.InternetModule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public abstract class InternetCheckReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        int status = NetworkUtil.getConnectivityStatusString(context);

        if (status == 0) {
            onNetworkDisConnected();
//            InternetDialog.showDialog(context);
        } else {
            onNetworkConnected();
//            InternetDialog.cancelDialog(context);
        }
    }

    protected abstract void onNetworkConnected();

    protected abstract void onNetworkDisConnected();

}