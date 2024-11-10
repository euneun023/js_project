package entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Setter
@Getter
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long edu_id;

    private Long user_id;

    private String school_bootcamp;
    private String degree_cert;
    private String edu_field;
    private Date edu_start_date;
    private Date edu_finish_date;

}
