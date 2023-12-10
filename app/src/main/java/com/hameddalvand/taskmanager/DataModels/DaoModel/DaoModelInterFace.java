package com.hameddalvand.taskmanager.DataModels.DaoModel;

import com.hameddalvand.taskmanager.DataModels.EntityModels.CodeEntity;
import com.hameddalvand.taskmanager.DataModels.EntityModels.UserEntity;

public interface DaoModelInterFace {

    public interface UserDaoModelInterFace{
        public UserEntity selectUser(String phoneNumber);
        public UserEntity addNewUser(String phoneNumber);



    }

    public interface CodeDaoModelInterFace{

        public CodeEntity addNewCode(UserEntity user);
        public CodeEntity getLastCode(UserEntity user);

    }
}
