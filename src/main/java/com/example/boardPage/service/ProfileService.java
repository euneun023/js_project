package com.example.boardPage.service;

import com.example.boardPage.repository.UserRepository;
import com.example.boardPage.dto.User;
import entity.User;
import repository.UserRepository;

import java.util.List;

public class ProfileService { //프로필조회


    private UserRepository userRepository;

    public List<User> getAllProfile(){
        return userRepository.findAll();
    }
    public User getProfileById(Long id){
        return userRepository.findById(id).orElse(null);
    }


}
