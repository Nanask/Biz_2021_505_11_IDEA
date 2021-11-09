package com.callor.student.service;

import com.callor.student.model.StudentVO;

// 이렇게 GenericService에 있는 것을 상속받게 되면 다른 것을 사용할 필요가 없게 됨
public interface StudentService extends GenericService<StudentVO, String> {

    // 학생정보를 새로 등록할 때, 학번을 넣어줄 가상 method
    public StudentVO insert();
}
