package com.example.boardPage.service;

import com.example.boardPage.repository.UserRepository;
import com.example.boardPage.entity.User;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProfileService { //프로필조회


    private final UserRepository userRepository;

    public ProfileService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllProfile(){
        return userRepository.findAll();
    }
    public User getProfileById(Long id){
        return userRepository.findById(id).orElse(null);
    }


}
