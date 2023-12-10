package com.hameddalvand.taskmanager.LoginModule.ByPhoneAndSms;


import com.hameddalvand.taskmanager.DataModels.DaoModel.CodeDaoModel;
import com.hameddalvand.taskmanager.DataModels.DaoModel.DaoModelInterFace;
import com.hameddalvand.taskmanager.DataModels.DaoModel.UserDaoModel;
import com.hameddalvand.taskmanager.DataModels.EntityModels.CodeEntity;
import com.hameddalvand.taskmanager.DataModels.EntityModels.UserEntity;
import com.hameddalvand.taskmanager.HelperModels.StringHelper;

public class LoginByPhoneAndSmsLoginByPhoneAndSmsPresentation implements InterfaceLoginByPhoneAndSms.LoginByPhoneAndSmsPresentationInterFace {
    InterfaceLoginByPhoneAndSms.LoginByPhoneAndSmsFragmentInterFace loginByPhoneAndSmsFragmentInterFace;
    private DaoModelInterFace.CodeDaoModelInterFace codeDaoModelInterFace;
    private DaoModelInterFace.UserDaoModelInterFace userDaoModelInterFace;

    private final short COUNT_REQUEST = 3 ;
    private final short TIME_REQUEST = 300 ;


    public LoginByPhoneAndSmsLoginByPhoneAndSmsPresentation(InterfaceLoginByPhoneAndSms.LoginByPhoneAndSmsFragmentInterFace loginByPhoneAndSmsFragmentInterFace) {
        this.loginByPhoneAndSmsFragmentInterFace = loginByPhoneAndSmsFragmentInterFace;
    }





    public void loginByLocaleDb(String phoneNumber) {
        this.codeDaoModelInterFace = new CodeDaoModel();
        this.userDaoModelInterFace = new UserDaoModel();
        UserEntity model=this.userDaoModelInterFace.selectUser(phoneNumber);
        if (model==null){
            //add new user
            UserEntity newUser = this.userDaoModelInterFace.addNewUser(phoneNumber);
            //add new code
            CodeEntity code = this.codeDaoModelInterFace.addNewCode(newUser);

            //send code for phone number by api


        }else {

            CodeEntity lastCode = this.codeDaoModelInterFace.getLastCode(model);
            if (lastCode!=null){
                if (lastCode.getCount_request()< COUNT_REQUEST ){
                    if (StringHelper.date_time_now()-
                            Long.valueOf(lastCode.getDate_time())>TIME_REQUEST){
                        // new code
                        CodeEntity code = this.codeDaoModelInterFace.addNewCode(model);
                        //send code for phone number by api
                    }else {
                        // waiting until last 300 second after try again
                    }


                }else {

                    //send code for phone number by api
                    lastCode.setCount_request((short) (lastCode.getCount_request()+1));
                    lastCode.save();
                    // countrequest++  ;

                }



            }else {
                // a bug
            }



        }
    }
}
