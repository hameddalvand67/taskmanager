package com.hameddalvand.taskmanager.models.DaoModel;

import com.hameddalvand.taskmanager.models.dataModels.CodeDataModel;
import com.hameddalvand.taskmanager.models.dataModels.UserDataModel;

import java.util.List;

public class UserDaoModel {




    public UserDataModel selectUser(String phoneNumber){
        List<UserDataModel> model=UserDataModel.find(
                UserDataModel.class, "phone = ? ",  phoneNumber);
         if (listIsOneItem(model))
            return model.get(0);
        return null;
    }

    public boolean listIsEmpty(List<UserDataModel> model){
        return model.size() == 0;
    }

    public boolean listIsOneItem(List<UserDataModel> model){
        return model.size() == 1;
    }

    public UserDataModel addNewUser(String phoneNumber){

        UserDataModel user = new UserDataModel(phoneNumber);
        user.save();
        return user;
    }
}
