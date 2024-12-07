package com.example.boardPage.service;

import com.example.boardPage.entity.Career;
import com.example.boardPage.repository.CareerRepository;
import org.springframework.stereotype.Service;

@Service
public class CareerService {

    private final CareerRepository careerRepository;

    public CareerService (CareerRepository careerRepository){
        this.careerRepository=careerRepository;
    }

    //프로필 경력 추가
    public Career addCareer(Career career){
        //예외처리 : 같은 company ?
        return careerRepository.save(career);
    }

    //프로필 경력 삭제
    public Career deleteCareer(Long id){
        Career career = careerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 id 입니다."));
        //Builder
        Career deleteCareer= career.toBuilder()
                .current(false)
                .build();
        return careerRepository.save(deleteCareer);
    }
}
