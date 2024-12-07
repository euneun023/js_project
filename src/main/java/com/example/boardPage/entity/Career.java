package com.example.boardPage.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Builder
@Setter
@Table(name ="career")
public class Career { /* 경력 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "career_id")
    private Long career_id;

    @ManyToOne(fetch = FetchType.LAZY)  //여러 career가 하나의 user에 속함
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "job_title")
    private String title;   //사용X

    @Column(name = "company") //회사
    private String company;

    @Column(name = "position") //직책
    private String position;

    @Column(name = "job_start_date")    //입사일
    private Date from;

    @Column(name = "job_finish_date")   //퇴사일
    private Date to;

    @Column(name = "job_description")   //경력 설명
    private String description;

    @Column(name = "company_domain")
    private String company_domain; //사용X

    @Column(name = "current")
    private Boolean current = true; //true로 기본설정해도될지?

    public CareerBuilder toBuilder() { //없앨방법있는지
        return builder()
                //.career_id(this.career_id)가 필요한가?
                .company(this.company)
                .position(this.position)
                .from(this.from)
                .to(this.to)
                .current(this.current)
                .description(this.description);
    }
}
