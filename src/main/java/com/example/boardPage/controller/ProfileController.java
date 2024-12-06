package com.example.boardPage.controller;

import com.example.boardPage.service.ProfileService;
import com.example.boardPage.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService){ // @RequiredArgsConstructor
        this.profileService =profileService;
    }

/*
    //프로필 조회
    @GetMapping("/{all}")
    public ResponseEntity<String> getAllProfiles(@PathVariable String username){
        Optional<Profile> profile = profileService.getAllProfile();
        // Optional을 처리하여 존재하면 프로필 반환, 없으면 404 상태 코드 반환
        return profile.map(u -> ResponseEntity.ok("User Profile: " + u.toString()))  // 프로필을 반환
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("사용자를 찾을 수 없습니다."));  // 사용자 없을 때
    }
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllProfiles() {
       List<User> users = profileService.getAllProfile();
      return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getProfileById(@PathVariable Long id){
    /    User user = profileService.getProfileById(id);
        if (user != null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
*/
    //프로필 등록 및 수정


    //프로필 경력 추가


    //프로필 경력 삭제


    //프로필 학력 추가


    //프로필 학력 삭제








}

