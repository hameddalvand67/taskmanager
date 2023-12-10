package com.hameddalvand.taskmanager.HelperModels.Validator;

public class ValidDataModel {
    String message;
    String errMessage;
    boolean validated;

    public ValidDataModel(String message, String errMessage, boolean validated) {
        this.message = message;
        this.errMessage = errMessage;
        this.validated = validated;
    }
}
