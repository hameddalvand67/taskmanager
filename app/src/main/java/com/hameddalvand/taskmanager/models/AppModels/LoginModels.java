package com.hameddalvand.taskmanager.models.AppModels;

import com.hameddalvand.taskmanager.interfaces.AppInterfaces;
import com.hameddalvand.taskmanager.models.DaoModel.CodeDaoModel;
import com.hameddalvand.taskmanager.models.DaoModel.UserDaoModel;
import com.hameddalvand.taskmanager.models.StringHelper;
import com.hameddalvand.taskmanager.models.dataModels.CodeDataModel;
import com.hameddalvand.taskmanager.models.dataModels.UserDataModel;
import com.hameddalvand.taskmanager.presenters.LoginPresentation;

import java.util.List;

public class LoginModels implements AppInterfaces.loginModelInterFace {
    UserDaoModel userDaoModel;
    CodeDaoModel codeDaoModel;
    AppInterfaces.loginPresentationInterFace loginPresentationInterFace;

    public LoginModels(AppInterfaces.loginPresentationInterFace loginPresentationInterFace) {
        this.loginPresentationInterFace=loginPresentationInterFace;
        this.userDaoModel=new UserDaoModel();
        this.codeDaoModel= new CodeDaoModel();
    }

    @Override
    public void loginLocaleDb(String phoneNumber) {
       UserDataModel model=userDaoModel.selectUser(phoneNumber);
       if (model==null){
           //add new user
           UserDataModel newUser = userDaoModel.addNewUser(phoneNumber);
            //add new code
           CodeDataModel code = this.codeDaoModel.addNewCode(newUser);

           //send code for phone number by api


       }else {

           CodeDataModel lastCode = this.codeDaoModel.getLastCode(model);
           if (lastCode!=null){
               if (lastCode.getCount_request()<3){
                   if (StringHelper.date_time_now()-
                           Long.valueOf(lastCode.getDate_time())>300){
                       // new code
                       CodeDataModel code = this.codeDaoModel.addNewCode(model);
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


    public void checkCountAndDateTime(UserDataModel model){
        if (model!=null){
            List<CodeDataModel> codeDataModels= model.getCodes(model);
            if (codeDataModels.size()==0){
                // CREATE NEW CODE

            }else  if (codeDataModels.size()==1){
                        //
            }else  if (codeDataModels.size()==2){

            }else  if (codeDataModels.size()==3){

            }
        }
    }
}
