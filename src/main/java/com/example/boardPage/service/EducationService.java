package com.example.boardPage.service;

import com.example.boardPage.entity.Education;
import com.example.boardPage.repository.EducationRepository;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationService (EducationRepository educationRepository){
        this.educationRepository = educationRepository;
    }

    //프로필 학력 추가
    public Education addEducation(Education education){
        return educationRepository.save(education);
    }

    //프로필 학력 삭제
    public Education deleteEducation(Long id){
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 id 입니다."));

        Education deleteEducation = education.toBuilder()
                .current(false)
                .build();
        return educationRepository.save(deleteEducation);
    }


}
