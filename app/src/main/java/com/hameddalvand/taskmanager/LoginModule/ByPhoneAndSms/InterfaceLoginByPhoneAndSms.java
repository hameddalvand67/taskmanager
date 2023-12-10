package com.hameddalvand.taskmanager.LoginModule.ByPhoneAndSms;

public interface InterfaceLoginByPhoneAndSms {

    public interface LoginByPhoneAndSmsPresentationInterFace {
        public void loginByLocaleDb(String phoneNumber);
    }

    public interface LoginByPhoneAndSmsFragmentInterFace {

      public  void getResponse(String state);
    }

}
