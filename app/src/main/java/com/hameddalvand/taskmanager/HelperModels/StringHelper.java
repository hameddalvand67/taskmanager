package com.hameddalvand.taskmanager.HelperModels;
import java.util.Date;
import java.util.Random;

public class StringHelper {

    public static String randomNumber(int min , int max){
        Random random = new Random();
        int randomNumber = random.nextInt(max + 1 - min) + min;
        return randomNumber+"";

    }


    public static long date_time_now(){
        return new Date().getTime()/1000;
    }

}
