package com.example.boardPage.dto;

import com.example.boardPage.entity.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProfileDTO {

    private String company; //화사

    private String website;

    private String location;

    private String bio;

    private String status;

    private String skills;

    @Builder
    public ProfileDTO(String company, String website, String location, String bio, String status, String skills){
        this.company=company;
        this.website=website;
        this.location=location;
        this.bio=bio;
        this.status=status;
        this.skills=skills;
    }

    //toEntity 와 toDTO는 안 써놔도 되는건지 ..?

    public User toEntity(){
        return User.builder()
                .company(company)
                .website(website)
                .location(location)
                .bio(bio)
                .status(status)
                .skills(skills)
                .build();
    }

    public ProfileDTO toDTO(User user){
        return ProfileDTO.builder()
                .company(user.getCompany())
                .website(user.getWebsite())
                .location(user.getLocation())
                .bio(user.getBio())
                .status(user.getStatus())
                .skills(user.getSkills())
                .build();
    }

}
