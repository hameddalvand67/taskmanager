package com.hameddalvand.taskmanager.DataModels.DaoModel;

import com.hameddalvand.taskmanager.DataModels.EntityModels.UserEntity;

import java.util.List;

public class UserDaoModel implements DaoModelInterFace.UserDaoModelInterFace {




    public UserEntity selectUser(String phoneNumber){
        List<UserEntity> model= UserEntity.find(
                UserEntity.class, "phone = ? ",  phoneNumber);
         if (listIsOneItem(model))
            return model.get(0);
        return null;
    }

    public boolean listIsEmpty(List<UserEntity> model){
        return model.size() == 0;
    }

    public boolean listIsOneItem(List<UserEntity> model){
        return model.size() == 1;
    }

    public UserEntity addNewUser(String phoneNumber){

        UserEntity user = new UserEntity(phoneNumber);
        user.save();
        return user;
    }
}
