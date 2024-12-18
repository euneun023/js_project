package com.example.boardPage.service;

import com.example.boardPage.dto.ProfileDTO;
import com.example.boardPage.repository.UserRepository;
import com.example.boardPage.entity.User;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService { //프로필조회

    private final UserRepository userRepository;

    public ProfileService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /*
    User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(
    () -> new IllegalArgumentException("사용자를 찾을 수 없습니다.")
);
     */

    //프로필 ID로 조회
    public ProfileDTO getProfileById (Long id){
        User user = userRepository.findByUserId(id)
                .orElseThrow(() -> new RuntimeException(id + " 프로필을 찾을 수 없습니다."));
      //  return profileDTO.toEntity(user);
            return convertToProfileDTO(user);
    }

    //프로필 전체 조회
    public List<ProfileDTO> getAllProfiles(){
        List<User> users = Optional.ofNullable(userRepository.findAll())
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new RuntimeException("프로필이 존재하지 않습니다."));

        List<ProfileDTO> profileDTOs = new ArrayList<>();
        for (User user : users){
            profileDTOs.add(convertToProfileDTO(user));
        }
        return profileDTOs;
    }


// toDTO와 비교했을때 뭐가더 나을지 !
    //Converter (to DTO) -- User 객체의 데이터를 ProfileDTO로 변환해서 반환
    private ProfileDTO convertToProfileDTO(User user){
        return new ProfileDTO(
            user.getCompany(),
            user.getWebsite(),
            user.getLocation(),
            user.getBio(),
            user.getStatus(),
            user.getSkills()
        );
    }
    //DB -> UserRepository.findAll : User 엔티티 가져옴
    //User --- convertToProfileDTO ---> ProfileDTO
    // profileDTO -> Client 반환


    //프로필 등록 및 수정
    public User createProfile(ProfileDTO profileDTO){
        User user = profileDTO.toEntity();
        return userRepository.save(user);
    }



}
