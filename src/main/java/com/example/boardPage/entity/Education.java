package com.example.boardPage.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@Table(name="education")
public class Education {    /* 학력 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edu_id")
    private Long edu_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
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

    @Column(name = "current")
    private Boolean current = true; //true로 기본설정해도될지?

    public EducationBuilder toBuilder(){
        return builder()
                //.edu_id(this.edu_id)
                .school(this.school)
                .degree(this.degree)
                .fieldOfString(this.fieldOfString)
                .from(this.from)
                .to(this.to)
                .current(this.current);
    }
}
