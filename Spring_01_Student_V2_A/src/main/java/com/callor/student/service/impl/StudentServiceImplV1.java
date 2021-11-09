package com.callor.student.service.impl;

import com.callor.student.model.StudentVO;
import com.callor.student.repository.StudentDao;
import com.callor.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stServiceV1")
public class StudentServiceImplV1 implements StudentService {

    private final StudentDao stDao;
// 생성자 주입방식
//    장점 : 메모리 누수방지, 발생할 수 있는 NullPointException 방지 가능
   public StudentServiceImplV1(StudentDao stDao) {
        this.stDao = stDao;
    }

    @Override
    public List<StudentVO> selectAll() {
       // 전체 데이터 조회
        return stDao.findAll();
    }

    @Override
    public StudentVO findById(String st_num) {
       // 학번으로 조회하기
        /**
         * findById 는 Optional type으로 데이터가 추출되므로
         * get() method 로 한번 분리해주어야 한다.
         */
       return stDao.findById(st_num).get();
    }

    @Override
    public void insert(StudentVO stVO) {
       // stVO 저장하기
        stDao.save(stVO);
    }

    @Override
    public void update(StudentVO stVO) {
       // stVO 수정하기
        stDao.save(stVO);
    }

    @Override
    public void delete(String st_num) {
       // st_num으로 삭제하기
        stDao.deleteById(st_num);
    }

    /**
     * 학생정보를 추가(새로등록)할 때 기존의 학번을 자동으로
     * 생성하여 학생 model 객체를 생성한 후
     * Controller 에서 wirte.jsp로 보내기
     * @return
     */
    @Override
    public StudentVO insert() {

        StudentVO stVO = StudentVO.builder()
                .st_num("20210001")
                .build();
        return stVO;
    }
}
