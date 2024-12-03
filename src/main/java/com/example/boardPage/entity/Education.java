package com.example.boardPage.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="education")
public class Education {    /* 학력 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edu_id")
    private Long edu_id;

    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "school_bootcamp")
    private String school;          //학교
    @Column(name = "degree_cert")
    private String degree;          //학년
    @Column(name = "edu_field")
    private String fieldOfString;   //전공
    @Column(name = "edu_start_date")
    private Date from;              //입학일
    @Column(name = "edu_finish_date")
    private Date to;                //종료일

    private Boolean current; //현재 다니고있는지 / ☆ DB 추가해야하는지?

}
