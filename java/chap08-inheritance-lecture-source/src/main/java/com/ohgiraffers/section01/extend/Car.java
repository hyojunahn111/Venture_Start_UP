package com.ohgiraffers.section01.extend;

public class Car {

    private boolean runningStaus;

    public Car(){
        System.out.println("Car 클래스의 기본 생성자 호출됨...");
    }

    public void run(){

        runningStaus = true;
        System.out.println("자동차가 달린다");

    }

    public void soundHorn(){

        if(isRunning()){
            System.out.println("자동차가 빵빵거림");

        }else{
            System.out.println("주행중이 아닌 생태에서 빵빵 할 수 없다");
        }


    }

    public void stop(){

        runningStaus = false;
        System.out.println("자동차가 멈춥니다");
    }

    protected boolean isRunning(){
        return runningStaus;
    }

}
