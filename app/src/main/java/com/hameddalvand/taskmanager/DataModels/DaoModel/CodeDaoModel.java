package com.hameddalvand.taskmanager.DataModels.DaoModel;

import com.hameddalvand.taskmanager.HelperModules.StringHelper;
import com.hameddalvand.taskmanager.DataModels.EntityModels.CodeEntity;
import com.hameddalvand.taskmanager.DataModels.EntityModels.UserEntity;

import java.util.List;

public class CodeDaoModel implements DaoModelInterFace.CodeDaoModelInterFace {

    public CodeEntity getLastCodeForUser(UserEntity userEntity){
        List<CodeEntity> codeEntities =
                userEntity.getCodes(userEntity);
        return null;
    }

    public CodeEntity addNewCode(UserEntity user) {

        CodeEntity code = new CodeEntity(
                user ,
                StringHelper.date_time_now()+"",
                (short) 0,
                StringHelper.randomNumber(1000,9999)
        );
        code.save();
        return code;
    }


    public CodeEntity getLastCode(UserEntity user) {
//          CodeDataModel.find(CodeDataModel.class,
//                "user = ?", String.valueOf(user.getId())
//                ,"","date_time DESC","1");
        List<CodeEntity> lastCode = CodeEntity.findWithQuery(CodeEntity.class, "Select MAX(date_time) from CodeDataModel where user = ?", String.valueOf(user.getId()));
        if (lastCode.size()>0)
            return lastCode.get(0);
        return addNewCode(user);

    }
}
