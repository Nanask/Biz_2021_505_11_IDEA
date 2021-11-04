package com.callor.student.controller;

import com.callor.student.model.StudentVO;
import com.callor.student.service.Impl.StService1;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class StController {

    private StService1 stService = new StService1();

    public void list() {
        // stService의 selectAll 데이터 가져오기
        List<StudentVO> stList = stService.selectAll();
        for(StudentVO vo : stList) {
            log.debug(vo.toString());
        }
    }
}
