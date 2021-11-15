package com.callor.readbook.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Value("${mysql.username}")
    private  String userName;

    @Value("${password}")
    private  String password;

    @Value("${driverClassName}")
    private  String className;

    @Value("${url}")
    private  String url;

//    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        logger.debug("여기는 main 입니다!");
        return "home/home";
//        return String.format("username %s\n" +
//                " password %s\n" +
//                "url %s\n" +
//                "dirver %s\n", userName,password,url,className);
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String book() {
        return "book/list";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write() {
        return "read/write";
    }
}
