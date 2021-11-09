package com.callor.student.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_score")
public class ScoreVO {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sc_seq;
    private String sc_stnum;
    private String sc_subject;
    private String sc_score;
}
