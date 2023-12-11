package com.hameddalvand.taskmanager.ValidatorModule;

public class ValidDataModel {
    String key;
    String value;
    String message;
    String errMessage;
    boolean validated;


    public ValidDataModel(String key, String value, String message, String errMessage, boolean validated) {
        this.key = key;
        this.value = value;
        this.message = message;
        this.errMessage = errMessage;
        this.validated = validated;
    }
}
