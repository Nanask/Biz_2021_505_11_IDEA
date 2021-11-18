package com.callor.js.repository;

import org.apache.ibatis.annotations.Select;

public interface DDL_Dao {

// ${create_table}: create_table에 담겨있는 문자열을 풀어서 사용하라
    @Select("${create_table}")
    public  void create_table(String create_table);
}
