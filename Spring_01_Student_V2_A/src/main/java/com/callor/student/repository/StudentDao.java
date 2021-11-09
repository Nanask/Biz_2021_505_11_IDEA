package com.callor.student.repository;

import com.callor.student.model.StudentVO;
import org.springframework.data.jpa.repository.JpaRepository;

// 이 친구가 이제 jpaRepository에 있는 method들을 갖고 있으니 사용하면 된다!
public interface StudentDao extends JpaRepository<StudentVO, String> {

}
