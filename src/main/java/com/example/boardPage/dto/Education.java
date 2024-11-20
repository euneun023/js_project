package com.example.boardPage.dto;

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
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edu_id")
    private Long edu_id;

    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "school_bootcamp")
    private String school_bootcamp;
    @Column(name = "degree_cert")
    private String degree_cert;
    @Column(name = "edu_field")
    private String edu_field;
    @Column(name = "edu_start_date")
    private Date edu_start_date;
    @Column(name = "edu_finish_date")
    private Date edu_finish_date;

}
