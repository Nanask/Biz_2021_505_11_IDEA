package com.callor.student.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class OracleVO {

    /**
     * 예시이므로 Entity는 붙이지 않는다
     * SEQ_ORACLE 이라는 이름으로 Sequence를 만들고
     * 증가값을 1씩 증가시켜라
     * 이 프로젝트에서 O_SEQ 라는 별명으로 사용하겠다.
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "O_SEQ")
    // 오라클버전으로 seq를 만들어라, 그리고 그 이름은 O_SEQ로 하겠다, 그리고 1씩 증가하게 해라
    /**
     * O_SEQ라는 별명으로 생성된 Sequence 를 사용하여
     * insert 할 때 o_seq 칼럼의 데이터를 생성해라
     */
    @SequenceGenerator(name = "O_SEQ", sequenceName = "SEQ_ORACLE", allocationSize = 1)
    @Id
    private Long o_seq;
}
