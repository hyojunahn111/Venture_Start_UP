package com.ohgiraffers.section02.common;

import org.springframework.stereotype.Component;

@Component
public class Squirtle implements Pokemon{
    @Override
    public void attack() {
        System.out.println("파이리 불대문자🔥🔥🔥");
    }
}
