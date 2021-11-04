package com.callor.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
@RequestMapping(value = "/stu")
public class StudentController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "list";
    }
}
