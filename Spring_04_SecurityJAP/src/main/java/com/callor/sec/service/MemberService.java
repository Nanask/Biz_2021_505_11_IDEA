package com.callor.sec.service;

import com.callor.sec.models.UserDetailsVO;

import java.util.List;

// Generic은 기본적인 CRUD를 구현하고 Service에서 추가적으로 method들을 추가해서 사용하겠다.
public interface MemberService extends GenericService<UserDetailsVO, String> {

    // GenericService에 선언된 기본 CRUD는 같이 상속받는다

   public List<UserDetailsVO> findByEmail(String email);
    public List<UserDetailsVO> findByTel(String tel);

    // DB에 저장된 사용자가 몇명이나 되는가?
    public int userCount();
}
