package com.ohgiraffers.section02.initdestory.sub03.xml;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Owner {

    @PostConstruct
    public void openShop(){
        System.out.println("사장님이 가게 문을 열었습니다. 쇼핑이나 하셔");
    }

    @PreDestroy
    public void closeShop(){
        System.out.println("사장님이 가게 문을 닫았쇼. 꺼지쇼");
    }

}
