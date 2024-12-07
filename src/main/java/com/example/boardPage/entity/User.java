package com.example.boardPage.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "profile_info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name" , unique = true)
    private String username;

    @Column(name = "email" , unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "profile_img")
    private String profile_img;

    @Column(name = "company")  // job
    private String company;

    @Column(name = "website")  // job
    private String website;

    @Column(name = "city_and_state")
    private String location;

    @Column(name = "bio") //self_introduce 자기소개
    private String bio;

    @Column(name = "status")
    private String status;  //현재 상태 - 예시데이터는?

    @Column(name = "skills")
    private String skills;



    @Column(name = "twitter_link")
    private String twitter_link;
    @Column(name = "facebook_link")
    private String facebook_link;
    @Column(name = "youtube_link")
    private String youtube_link;
    @Column(name = "linkedin_link")
    private String linkedin_link;
    @Column(name = "instagram_link")
    private String instagram_link;
    @Column(name = "enabled")
    private boolean enabled;
}
