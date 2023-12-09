package com.hameddalvand.taskmanager.models.Validator;

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
