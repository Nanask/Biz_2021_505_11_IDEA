package com.callor.student.controller;

import com.callor.student.model.StudentVO;
import com.callor.student.service.StService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
// @Autowired 를 사용하게 되면
//     public void setStService(StService stService)  {
//        this.stService = stService;
//    }
// 는 사용할 필요가 없는 코드가 된다.
//  @Autowired가 객체를 주입받도록 해서 사용할 수 잇게 만듬
// 둘중에 하나라도 없으면 오류가 발생할 수 있음
public class StController2 {

    // 인터페이스로 선언만 하기
    private StService stService ;

    // setter() 를 통해서 객체를 주입받도록 하기
    public void setStService(StService stService)  {
        this.stService = stService;
    }

    public void list() {
        // stService의 selectAll 데이터 가져오기
        List<StudentVO> stList = stService.selectAll();
        for(StudentVO vo : stList) {
            log.debug(vo.toString());
        }
    }
}
