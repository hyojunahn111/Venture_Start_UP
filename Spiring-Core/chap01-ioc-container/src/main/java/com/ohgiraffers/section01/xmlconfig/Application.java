package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        /* 1. */
//        MemberDTO member = (MemberDTO) context.getBean("member");

        /* 2. */
//        MemberDTO member = context.getBean(MemberDTO.class);

        /* 3. */
        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println(member);
    }

}
