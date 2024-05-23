package com.ohgiraffers.exceptionhandler;

import org.springframework.web.bind.annotation.RequestMapping;

public class MainController {

    @RequestMapping(value = {"/", "main"})
    public String main() {
        return "main";
    }
}
