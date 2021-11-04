package com.callor.student.repository;

import com.callor.student.model.StudentVO;

import java.util.List;

public interface StDao {

    public List<StudentVO> selectAll();
    public StudentVO findById();
    public void insert(StudentVO VO);
    public void update(StudentVO VO);
    public void delete(String st_num);
}
