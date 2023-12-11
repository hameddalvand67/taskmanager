package com.hameddalvand.taskmanager.ValidatorModule;

public class Validation {

    public  ValidDataModel phoneValidate(String viewName ,String phone) {

          String  MESSAGE="در وارد کردن شماره تلفن دقت کنید";
          String  ERR_MESSAGE="شماره تلفن درست وارد نشده است";

        String regexPatternPhone1 = "0(\\d{10})";
        String regexPatternPhone2 = "(\\d{10})";
        boolean isValid1 = phone.matches(regexPatternPhone1);
        boolean isValid2 = phone.matches(regexPatternPhone2);
        if (isValid1 || isValid2){
            return new ValidDataModel(viewName , phone ,"","",true);
        }else {
            return new ValidDataModel(viewName,phone,MESSAGE,ERR_MESSAGE,false);
        }


    }
}
