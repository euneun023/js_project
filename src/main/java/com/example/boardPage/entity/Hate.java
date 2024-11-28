package com.example.boardPage.entity;

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
public class Hate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hate_id;

    private Long post_id;
    private Long user_id;
    private Date hate_time;

}
