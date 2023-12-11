package com.hameddalvand.taskmanager.TimerModule;

import androidx.annotation.NonNull;

import com.androchef.happytimer.countdowntimer.DynamicCountDownView;
import com.androchef.happytimer.countdowntimer.HappyTimer;

public class Timer {
    DynamicCountDownView view;
    InterFaceTimer interFaceTimer;


    public Timer(DynamicCountDownView view , int time ,  InterFaceTimer interFaceTimer) {
        this.view = view;
        this.interFaceTimer=interFaceTimer;
        initTimer(time);
        view.setOnTickListener(new HappyTimer.OnTickListener() {
            @Override
            public void onTick(int i, int i1) {
                interFaceTimer.getRemainingTime(i1+"");
                if (i1==0){
                    interFaceTimer.endTime();
                    view.stopTimer();
                }


            }

            @Override
            public void onTimeUp() {

            }
        });

        view.setStateChangeListener(new HappyTimer.OnStateChangeListener() {
            @Override
            public void onStateChange(@NonNull HappyTimer.State state, int i, int i1) {

            }
        });
    }


    public void initTimer(int time){
        view.initTimer(time, HappyTimer.Type.COUNT_DOWN);
    }

    public void start(){
        view.startTimer();

    }

    public void stop(){
        view.stopTimer();
    }


    public void pause(){
        view.pauseTimer();
    }

    public void reset(){
        view.resetTimer();
    }


}
