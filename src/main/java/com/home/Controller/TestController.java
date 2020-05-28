package com.home.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/testkmg")
    public String welcomeTest(){
        return "welcome kmg";
    }
}
