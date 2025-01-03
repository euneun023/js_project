package com.example.boardPage.controller;

import com.example.boardPage.entity.Education;
import com.example.boardPage.service.EducationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile/education")
public class EducationController {

    private final EducationService educationService;

    public EducationController (EducationService educationService){
        this.educationService=educationService;
    }

    //프로필 학력 추가 : [PUT] ~/api/profile/education
    @PutMapping
    public String addEducation(@RequestBody Education education){
        try{
            Education addEducation = educationService.addEducation(education);
            return "학력 추가 완료";
        } catch (Exception e){
            return "학력 추가 실패 : " + e.getMessage();
        }
    }

    //프로필 학력 삭제 : [DELETE] ~/api/profile/education/:education_id
    @DeleteMapping("/{edu_id}")
    public String deleteEducation(@PathVariable Long id){
        try{
            Education deleteEducation = educationService.deleteEducation(id);
            return "학력 삭제 완료";
        }catch (Exception e){
            return "학력 삭제 실패 : " + e.getMessage();
        }
    }

}
