package com.callor.student.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="tbl_student")
public class StudentVO {

//    변수이름과 칼럼명이 같다면 생략해도 되지만 그래도 기록하는 습관을 들여보자..?

    @Id
    @Column(name = "st_num", columnDefinition = "VARCHAR(8)")
    private String st_num;
    @Column(name = "st_name", columnDefinition = "VARCHAR(20)")
    private String st_name;
    @Column(name = "st_dept", columnDefinition = "VARCHAR(8)")
    private String st_dept;
    @Column(name = "st_grade", columnDefinition = "VARCHAR(1)")
    private String st_grade;
    @Column(name = "st_tel", columnDefinition = "VARCHAR(20)")
    private String st_tel;

//    column만 작성할 경우 글자수는 256개까지 들어갈 수 있다
    @Column
    private String st_address;

}
