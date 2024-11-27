package com.example.boardPage.controller;

import com.example.boardPage.service.ProfileService;
import com.example.boardPage.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<User>> getAllProfiles() {
        List<User> users = profileService.getAllProfile();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getProfileById(@PathVariable Long id){
        User user = profileService.getProfileById(id);
        if (user != null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

}

