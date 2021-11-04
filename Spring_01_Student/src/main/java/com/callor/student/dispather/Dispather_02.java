package com.callor.student.dispather;

import com.callor.student.controller.StController2;
import com.callor.student.service.StService;
import com.callor.student.service.Impl.StService2;


public class Dispather_02 {

    public static void main(String[] args) {

        StController2 stCon = new StController2();
        StService stServie = new StService2();
        stCon.setStService(stServie);
        stCon.list();
    }
}
