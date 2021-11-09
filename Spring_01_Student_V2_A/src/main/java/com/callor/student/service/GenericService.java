package com.callor.student.service;

import java.util.List;

public interface GenericService<M, PK> {

    // 똑같은 interface 가 사용되지 않도록 공통된 interface 생성
    public List<M> selectAll();
    public M findById(PK pk);

    public void insert(M model);
    public void update(M model);
    public void delete(PK pk);

}
