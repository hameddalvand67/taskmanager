package com.hameddalvand.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.hameddalvand.taskmanager.RegisterAndLoginModule.LoginByCodeSms.LoginByCodeSmsFragment;
import com.hameddalvand.taskmanager.RegisterAndLoginModule.RegisterByPhoneAndSms.RegisterByPhoneAndSmsFragment;

public class MainActivity extends AppCompatActivity implements InterFaceMainActivity {


    public  RegisterByPhoneAndSmsFragment registerByPhoneAndSmsFragment;
    public LoginByCodeSmsFragment loginByCodeSmsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startRegisterByPhoneAndSmsFragment();

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

    @Override
    public void startRegisterByPhoneAndSmsFragment() {
        this.registerByPhoneAndSmsFragment=new RegisterByPhoneAndSmsFragment(this);
        replaceFragment(this.registerByPhoneAndSmsFragment,null,false);
    }

    @Override
    public void startLoginByCodeSmsFragment() {
        this.loginByCodeSmsFragment=new LoginByCodeSmsFragment(this);
        replaceFragment(this.loginByCodeSmsFragment,null,false);
    }
}