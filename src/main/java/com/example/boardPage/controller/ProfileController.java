package com.example.boardPage.controller;

import com.example.boardPage.dto.ProfileDTO;
import com.example.boardPage.service.ProfileService;
import com.example.boardPage.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService){ // @RequiredArgsConstructor
        this.profileService =profileService;
    }

    //프로필 id 조회
    @GetMapping("/{id}")
    public ProfileDTO getProfileById(@PathVariable Long id) {
        return profileService.getProfileById(id); // ProfileDTO 객체를 반환
    }

    //프로필 전체 조회
    @GetMapping("/all")
    public List<ProfileDTO> getAllProfiles(){
        List<ProfileDTO> profileDTOs = profileService.getAllProfiles();
        if(profileDTOs.isEmpty()){
            return null;
        }
        return profileDTOs;
    }


    //프로필 등록 및 수정 : [POST] ~/api/profile
    @PostMapping
    public String createProfile(@RequestBody ProfileDTO profileDTO){
        try {
            User user = profileService.createProfile(profileDTO);
            return "프로필 등록 및 수정 완료";
        } catch (Exception e){
            return "프로필 생성 실패 : " + e.getMessage();
        }

    }





}

