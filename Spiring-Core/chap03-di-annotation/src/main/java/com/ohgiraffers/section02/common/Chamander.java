package com.ohgiraffers.section02.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
/*
* (sub01.primary)
* @Primary 어노테이션을 설정하면 @Autowired로 동일한 타입의 여러 bean을 찾게 되는 경우,
* 자동으로 우선시 할 타입으로 설정된다
* 동일한 타입의 클래스 중 한 개만 @Primary 어노테이션을 사용할 수 있다
* */
@Primary
public class Chamander implements Pokemon{
    @Override
    public void attack() {
        System.out.println("꼬북이 폭포오르기💧💧💧");
    }
}
