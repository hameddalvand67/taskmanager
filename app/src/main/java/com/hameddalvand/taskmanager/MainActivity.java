package com.hameddalvand.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.hameddalvand.taskmanager.LoginModule.ByPhoneAndSms.LoginByPhoneAndSmsByPhoneAndSmsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new LoginByPhoneAndSmsByPhoneAndSmsFragment(),null,false);

    }


    public void replaceFragment(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment, tag);
        if (addToBackStack)
            fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();

//        how use in fragment
//        MainActivity mainActivity= (MainActivity) getActivity();
//        mainActivity.replaceFragment(
//                new HomeFragment(),
//                HOME_FRAGMENT_TAG ,
//                true);

    }
}