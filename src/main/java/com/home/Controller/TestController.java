package com.home.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/testkmg")
    public String welcomeTest(){
        return "welcome kmg";
    }

    @RequestMapping(value = "/user")
    public String user(){
        return "welcome user";
    }

    @RequestMapping(value = "/admin")
    public String admin(){
        return "welcome admin";
    }
}
