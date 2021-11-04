package com.callor.student.service;

import com.callor.student.model.StudentVO;

import java.util.List;

// 설계할때 잘하자
public interface StudentService {

    public List<StudentVO> selectAll();

    public StudentVO findByNum(String st_num);

    public List<StudentVO> findByName(String st_name);
    public List<StudentVO> findByTel(String st_tel);

    public List<StudentVO> findByDept(String st_dept);
    public List<StudentVO> findByGrade(String st_grade);

    // 학생 데이터 추가할때 학번을 생성하여 새로운 학번을 생성하여
    // studentVO 개체 만드는 method
    public StudentVO insert();

    // DB에 추가하는 method
    public void insert(StudentVO stVO);

    public void update(StudentVO stVO);
    public void delete(String st_num);
}
