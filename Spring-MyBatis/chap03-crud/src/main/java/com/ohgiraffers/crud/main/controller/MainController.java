package com.ohgiraffers.crud.main.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    @GetMapping("/")
    public String defaultMain(){
        return "main";
    }

    @GetMapping("main")
    public void main(){}



}
