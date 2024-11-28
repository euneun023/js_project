package com.example.boardPage.controller;

import com.example.boardPage.service.UserService;
import com.example.boardPage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  // 주로 json  <=> controller : 주로 http 페이지
@RequestMapping("/api")
public class UserController {
/*
- GET /api/auth
- GET /api/profile/me

[POST] ~/api/auth
회원가입 : [POST] ~/api/users
로그인 : [POST] ~/api/auth
 */

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //회원가입
    @PostMapping("/users")
    public ResponseEntity<String> signup(@RequestBody User user){ //Dto : UserDto userDto
        try{


            String result = userService.registerUser(user); //userDto
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during registration"); // 상태 코드 500
    }

    }

    //로그인
    @PostMapping("/auth")
    public  ResponseEntity<String> login(@RequestBody User loginRequest){
        try {
            //로그인 후, jwt 토큰 반환
            String token = userService.login(loginRequest);
            return ResponseEntity.ok(token);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("로그인 실패__ " + e.getMessage());
        }
    }
}
