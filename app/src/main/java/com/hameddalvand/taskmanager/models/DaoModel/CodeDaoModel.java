package com.hameddalvand.taskmanager.models.DaoModel;

import com.hameddalvand.taskmanager.models.StringHelper;
import com.hameddalvand.taskmanager.models.dataModels.CodeDataModel;
import com.hameddalvand.taskmanager.models.dataModels.UserDataModel;

import java.util.List;

public class CodeDaoModel {

    public CodeDataModel getLastCodeForUser(UserDataModel userDataModel){
        List<CodeDataModel> codeDataModels =
                userDataModel.getCodes(userDataModel);
        return null;
    }

    public CodeDataModel addNewCode(UserDataModel user) {

        CodeDataModel code = new CodeDataModel(
                user ,
                StringHelper.date_time_now()+"",
                (short) 0,
                StringHelper.randomNumber(1000,9999)
        );
        code.save();
        return code;
    }


    public CodeDataModel getLastCode(UserDataModel user) {
//          CodeDataModel.find(CodeDataModel.class,
//                "user = ?", String.valueOf(user.getId())
//                ,"","date_time DESC","1");
        List<CodeDataModel> lastCode = CodeDataModel.findWithQuery(CodeDataModel.class, "Select MAX(date_time) from CodeDataModel where user = ?", String.valueOf(user.getId()));
        if (lastCode.size()>0)
            return lastCode.get(0);
        return addNewCode(user);

    }
}
