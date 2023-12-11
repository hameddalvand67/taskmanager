package com.hameddalvand.taskmanager.RegisterAndLoginModule.RegisterByPhoneAndSms;


import com.hameddalvand.taskmanager.DataModels.DaoModel.CodeDaoModel;
import com.hameddalvand.taskmanager.DataModels.DaoModel.DaoModelInterFace;
import com.hameddalvand.taskmanager.DataModels.DaoModel.UserDaoModel;
import com.hameddalvand.taskmanager.DataModels.EntityModels.CodeEntity;
import com.hameddalvand.taskmanager.DataModels.EntityModels.UserEntity;
import com.hameddalvand.taskmanager.HelperModules.StringHelper;

public class RegisterByPhoneAndSmsPresentation implements InterfaceRegisterByPhoneAndSms.RegisterByPhoneAndSmsPresentationInterFace {
    InterfaceRegisterByPhoneAndSms.RegisterByPhoneAndSmsFragmentInterFace registerByPhoneAndSmsFragmentInterFace;


    public RegisterByPhoneAndSmsPresentation(InterfaceRegisterByPhoneAndSms.RegisterByPhoneAndSmsFragmentInterFace registerByPhoneAndSmsFragmentInterFace) {
        this.registerByPhoneAndSmsFragmentInterFace = registerByPhoneAndSmsFragmentInterFace;
    }



    public static final String SEND_CODE="SEND_CODE";
    public static final String WAIT_TIME="WAIT_TIME";
    public static final String TRY_AGAIN="TRY_AGAIN";



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

            registerByPhoneAndSmsFragmentInterFace.getResponse(SEND_CODE);

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

                        registerByPhoneAndSmsFragmentInterFace.getResponse(SEND_CODE);
                    }else {

                        registerByPhoneAndSmsFragmentInterFace.pleaseWait();

                        // waiting until last 300 second after try again

                        registerByPhoneAndSmsFragmentInterFace.getResponse(WAIT_TIME);
                    }


                }else {

                    //send code for phone number by api
                    lastCode.setCount_request((short) (lastCode.getCount_request()+1));
                    lastCode.save();
                    // countrequest++  ;


                    registerByPhoneAndSmsFragmentInterFace.getResponse(SEND_CODE);



                }



            }else {
                // a bug

                registerByPhoneAndSmsFragmentInterFace.getResponse(TRY_AGAIN);
            }



        }
    }
}
