package com.example.boardPage.controller;


import com.example.boardPage.entity.Career;
import com.example.boardPage.service.CareerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile/experience") // url api 부터 쓰는게맞나 ..?!
public class CareerController {

    private final CareerService careerService;

    public CareerController (CareerService careerService){
        this.careerService=careerService;
    }

    //프로필 경력 추가 : [PUT] ~/api/profile/experience
    @PutMapping
    public String addCareer(@RequestBody Career career){
        try{
            Career addCareer = careerService.addCareer(career);
            return "경력 추가 완료";
        } catch (Exception e){
            return "경력 추가 실패 : " + e.getMessage();
        }
    }

    //프로필 경력 삭제 : [DELETE] ~/api/profile/experience/:experience_id
    @DeleteMapping("/{career_id}")
    public String deleteCareer(@PathVariable(value = "career_id") Long id){
        try {
            Career deleteCareer = careerService.deleteCareer(id);
            return "경력 삭제 완료";
        }catch (Exception e){
            return "경력 삭제 실패 : " + e.getMessage();
        }

    }

}
