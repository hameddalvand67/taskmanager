package com.hameddalvand.taskmanager.LoginModule.ByPhoneAndSms;


import com.hameddalvand.taskmanager.DataModels.DaoModel.CodeDaoModel;
import com.hameddalvand.taskmanager.DataModels.DaoModel.DaoModelInterFace;
import com.hameddalvand.taskmanager.DataModels.DaoModel.UserDaoModel;
import com.hameddalvand.taskmanager.DataModels.EntityModels.CodeEntity;
import com.hameddalvand.taskmanager.DataModels.EntityModels.UserEntity;
import com.hameddalvand.taskmanager.HelperModels.StringHelper;

public class LoginByPhoneAndSmsLoginByPhoneAndSmsPresentation implements InterfaceLoginByPhoneAndSms.LoginByPhoneAndSmsPresentationInterFace {
    InterfaceLoginByPhoneAndSms.LoginByPhoneAndSmsFragmentInterFace loginByPhoneAndSmsFragmentInterFace;


    public LoginByPhoneAndSmsLoginByPhoneAndSmsPresentation(InterfaceLoginByPhoneAndSms.LoginByPhoneAndSmsFragmentInterFace loginByPhoneAndSmsFragmentInterFace) {
        this.loginByPhoneAndSmsFragmentInterFace = loginByPhoneAndSmsFragmentInterFace;
    }





    public void loginByLocaleDb(String phoneNumber) {
        DaoModelInterFace.CodeDaoModelInterFace codeDaoModelInterFace = new CodeDaoModel();
        DaoModelInterFace.UserDaoModelInterFace userDaoModelInterFace = new UserDaoModel();
        UserEntity model= userDaoModelInterFace.selectUser(phoneNumber);
        if (model==null){
            //add new user
            UserEntity newUser = userDaoModelInterFace.addNewUser(phoneNumber);
            //add new code
            CodeEntity code = codeDaoModelInterFace.addNewCode(newUser);

            //send code for phone number by api

            loginByPhoneAndSmsFragmentInterFace.getResponse("");

        }else {

            CodeEntity lastCode = codeDaoModelInterFace.getLastCode(model);
            if (lastCode!=null){
                short COUNT_REQUEST = 3;
                if (lastCode.getCount_request()< COUNT_REQUEST){
                    short TIME_REQUEST = 300;
                    if (StringHelper.date_time_now()-
                            Long.valueOf(lastCode.getDate_time())> TIME_REQUEST){
                        // new code
                        CodeEntity code = codeDaoModelInterFace.addNewCode(model);
                        //send code for phone number by api

                        loginByPhoneAndSmsFragmentInterFace.getResponse("");
                    }else {
                        // waiting until last 300 second after try again

                        loginByPhoneAndSmsFragmentInterFace.getResponse("");
                    }


                }else {

                    //send code for phone number by api
                    lastCode.setCount_request((short) (lastCode.getCount_request()+1));
                    lastCode.save();
                    // countrequest++  ;


                    loginByPhoneAndSmsFragmentInterFace.getResponse("");



                }



            }else {
                // a bug

                loginByPhoneAndSmsFragmentInterFace.getResponse("");
            }



        }
    }
}
