package com.ohgiraffers.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import static jdk.tools.jlink.internal.plugins.PluginsResourceBundle.getMessage;

public class ExecptionHandlerController {

    @GetMapping("controller-null")
    public String nullPointExceptionTest(){

        String str = null;
        System.out.println(str.charAt(0));

        return "/";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception){

        System.out.println("controller 레벨의 exception 처리");
        System.out.println(exception, getMessage());


    }

    @GetMapping("controller-user")
    public String userExceptionTest() throws MemberRegistException{

        boolean check = true;

        if(check) {
            throw new MemberRegistException("당신은 회원자격이 없습니다!");
        }


        return "/";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(MemberRegistException exception, Model model){

        System.out.println("controller 레벨의 사용자 정의 exception 처리");
        return "error/memberRegistException";
    }
}
