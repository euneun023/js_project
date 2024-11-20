package com.example.boardPage.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@Table(name ="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    private Long user_id;

    private String title;
    private Date post_date;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Byte enabeld;
}
