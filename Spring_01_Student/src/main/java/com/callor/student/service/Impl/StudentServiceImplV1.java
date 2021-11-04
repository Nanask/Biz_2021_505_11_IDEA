package com.callor.student.service.Impl;

import com.callor.student.model.StDaoImpl;
import com.callor.student.model.StudentVO;
import com.callor.student.repository.StDao;
import com.callor.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

// Ioc 컨테이너에게 studentServiceImplV1 클래스를 사용하여 객체를 생성하고
// 필요한 곳에 주입해 달라
// 컴포넌트 어노테이션
@Service
public class StudentServiceImplV1 implements StudentService {

    private StDao stDao;

    // 주입할 method
    public StudentServiceImplV1(StDao stDao) {
        this.stDao = stDao;
    }

    // 얘는 임시
    public StudentServiceImplV1() {
        stDao = new StDaoImpl();
    }


    @Override
    public List<StudentVO> selectAll() {

        List<StudentVO> stVO = stDao.selectAll();
        return stVO;
    }

    @Override
    public StudentVO findByNum(String st_num) {
        return null;
    }

    @Override
    public List<StudentVO> findByName(String st_name) {
        return null;
    }

    @Override
    public List<StudentVO> findByTel(String st_tel) {
        return null;
    }

    @Override
    public List<StudentVO> findByDept(String st_dept) {
        return null;
    }

    @Override
    public List<StudentVO> findByGrade(String st_grade) {
        return null;
    }

    @Override
    public StudentVO insert() {
        return null;
    }

    @Override
    public void insert(StudentVO stVO) {

    }

    @Override
    public void update(StudentVO stVO) {

    }

    @Override
    public void delete(String st_num) {

    }
}
