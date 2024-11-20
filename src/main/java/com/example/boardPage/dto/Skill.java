package com.example.boardPage.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name ="skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long skill_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "skill_name")
    private String skill_name;

}
