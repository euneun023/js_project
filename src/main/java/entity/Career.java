package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long career_id;

    private Long user_id;

    private String job_title;
    private String company;
    private String position;
    private Date job_start_date;
    private Date job_finish_date;
    private String job_description;
    private String company_domain;



}
