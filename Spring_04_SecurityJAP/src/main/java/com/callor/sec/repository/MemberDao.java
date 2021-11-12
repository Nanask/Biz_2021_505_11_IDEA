package com.callor.sec.repository;

import com.callor.sec.models.UserDetailsVO;
import org.springframework.data.jpa.repository.JpaRepository;
// userDetails로 repo를 하려고 하다가 문제가 생길것같아서 VO로 함
public interface MemberDao extends JpaRepository<UserDetailsVO, String> {
}
