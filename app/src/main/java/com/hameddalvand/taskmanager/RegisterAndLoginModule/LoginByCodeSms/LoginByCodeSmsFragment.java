package com.hameddalvand.taskmanager.RegisterAndLoginModule.LoginByCodeSms;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hameddalvand.taskmanager.InterFaceMainActivity;
import com.hameddalvand.taskmanager.R;

public class LoginByCodeSmsFragment extends Fragment {

    InterFaceMainActivity interFaceMainActivity;
    public LoginByCodeSmsFragment(InterFaceMainActivity interFaceMainActivity) {
       this.interFaceMainActivity=interFaceMainActivity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_code, container, false);
        return view;
    }
}