package com.callor.js.service.impl;

import com.callor.js.repository.DDL_Dao;
import com.callor.js.repository.sql.CreateTableSQL;
import org.springframework.stereotype.Service;

@Service("bookServiceV1")
public class BookServiceImplV1 {
    private final DDL_Dao ddlDao;

    public BookServiceImplV1(DDL_Dao ddlDao) {
        this.ddlDao = ddlDao;

        ddlDao.create_table(CreateTableSQL.create_book_table);
    }
}
