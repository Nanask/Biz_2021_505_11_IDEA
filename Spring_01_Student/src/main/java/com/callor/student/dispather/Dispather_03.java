package com.callor.student.dispather;

import com.callor.student.controller.StController3;
import com.callor.student.service.StService;
import com.callor.student.service.Impl.StService2;

public class Dispather_03 {

    public static void main(String[] args) {


        StService stService = new StService2();
        // 생성자를 만드는 과정에서 주입?
        StController3 stCon = new StController3(stService);
        // setter방식이 없어서 오류발생
//        stCon.setStService(stServie);
        stCon.list();
    }
}
