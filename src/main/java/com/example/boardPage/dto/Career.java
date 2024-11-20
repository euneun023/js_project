package com.example.boardPage.dto;

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
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "career_id")
    private Long career_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "job_title")
    private String job_title;

    @Column(name = "company")
    private String company;

    @Column(name = "position")
    private String position;

    @Column(name = "job_start_date")
    private Date job_start_date;

    @Column(name = "job_finish_date")
    private Date job_finish_date;

    @Column(name = "job_description")
    private String job_description;

    @Column(name = "company_domain")
    private String company_domain;



}
