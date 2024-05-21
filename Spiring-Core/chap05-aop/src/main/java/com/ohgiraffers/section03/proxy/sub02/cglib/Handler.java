package com.ohgiraffers.section03.proxy.sub02.cglib;

import com.ohgiraffers.section03.proxy.common.SahmyookUniStudent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    private final SahmyookUniStudent student;

    public Handler(SahmyookUniStudent student) {
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("=== 공부라네??? =====");
        System.out.println("(호출 대상 메소드) " + method);
        System.out.println("(전달된 인자)");
        for(Object arg : args) {
            System.out.println(arg);
        }
        method.invoke(student, args);

        System.out.println("오늘도 불태움ㅋㅋ");

        return proxy;
    }
}
