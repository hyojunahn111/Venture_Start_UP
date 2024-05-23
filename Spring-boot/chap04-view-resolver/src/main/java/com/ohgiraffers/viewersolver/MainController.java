package com.ohgiraffers.viewersolver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

public class MainController {

    @RequestMapping(value={"/", "main"})
    public String main(){
        return "main";
    }

}
