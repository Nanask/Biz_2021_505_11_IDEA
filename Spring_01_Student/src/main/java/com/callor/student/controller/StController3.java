package com.callor.student.controller;

import com.callor.student.model.StudentVO;
import com.callor.student.service.StService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class StController3 {

    // 생성자 주입방식
    public StController3(StService stService) {
        this.stService = stService;
    }

    // 인터페이스로 선언만 하기
    private final StService stService ;

    public void list() {
        // stService의 selectAll 데이터 가져오기
        List<StudentVO> stList = stService.selectAll();
        for(StudentVO vo : stList) {
            log.debug(vo.toString());
        }
    }
}
