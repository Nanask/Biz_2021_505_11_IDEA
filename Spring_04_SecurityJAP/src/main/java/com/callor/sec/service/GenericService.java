package com.callor.sec.service;

import java.util.List;

// 매개변수와 사용할 VO를 자동으로 채워서 사용할 수 있음
// 중복된 코드를 막을 수 있다.
// 여러 service interface를 만들기 위한 구조형 interface
// Generic 을 사용하여 interface를 선언하였다
// 기본 CRUD 5개의 method를 선언
public interface GenericService<VO,PK> {

    public List<VO> selectAll();
    public VO findById(PK pk);

    public void insert(VO vo);
    public void update(VO vo);
    public void delete(PK pk);
}
