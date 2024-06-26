package com.ohgiraffers.exceptionhandler;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

public class RootConfiguration {

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {

        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();

        Properties props = new Properties();
        props.setProperty("java.lang.NullPointerException", "error/nullPointer");
//        props.setProperty("MemberRegistException", "error/memberRegist");

        exceptionResolver.setExceptionMappings(props);
//        exceptionResolver.setExceptionAttribute("exceptionMessage");
        exceptionResolver.setDefaultErrorView("error/default");

        return exceptionResolver;
    }

}
