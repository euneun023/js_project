package com.example.boardPage.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name ="career")
@NoArgsConstructor
public class Career { /* 경력 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "career_id")
    private Long career_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "job_title")
    private String job_title;

    @Column(name = "company") //회사
    private String company;

    @Column(name = "position") //직책
    private String position;

    @Column(name = "job_start_date")    //입사일
    private Date from;

    @Column(name = "job_finish_date")   //퇴사일
    private Date to;

    @Column(name = "job_description")   //경력 설명
    private String job_description;

    @Column(name = "company_domain")
    private String company_domain;

    private Boolean current; //현재 다니고있는지 / ☆ DB 추가해야하는지?



}
