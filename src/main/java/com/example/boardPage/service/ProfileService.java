package com.example.boardPage.service;

import com.example.boardPage.repository.UserRepository;
import com.example.boardPage.entity.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProfileService { //프로필조회


    private UserRepository userRepository;

    private Profile

    public ProfileService(UserRepository userRepository, ProfileService profileService){
        this.userRepository
        this.profileService = profileService;
    }


    public Optional<Profile> getAllProfile(){
        return .findAll();
    }
    public User getProfileById(Long id){
        return userRepository.findById(id).orElse(null);
    }


}
