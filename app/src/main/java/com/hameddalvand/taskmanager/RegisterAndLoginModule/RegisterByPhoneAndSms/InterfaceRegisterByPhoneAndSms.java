package com.hameddalvand.taskmanager.RegisterAndLoginModule.RegisterByPhoneAndSms;

public interface InterfaceRegisterByPhoneAndSms {

    public interface RegisterByPhoneAndSmsPresentationInterFace {
        public void loginByLocaleDb(String phoneNumber);
    }

    public interface RegisterByPhoneAndSmsFragmentInterFace {

      public  void getResponse(String state);

        void pleaseWait();
    }

}
