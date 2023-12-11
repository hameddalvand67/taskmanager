package com.hameddalvand.taskmanager.ValidatorModule;

import java.util.ArrayList;

public class Validator {
    public ArrayList<ValidDataModel> validDataModels;
    public Validation validation;

    public Validator() {
        this.validDataModels =new ArrayList<ValidDataModel>();
        this.validation= new Validation();
    }


    public boolean isValid(){
        for (ValidDataModel model:this.validDataModels) {
            if (!model.validated)
                return false;
        }
        return true;
    }
}
