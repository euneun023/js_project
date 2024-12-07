package com.example.boardPage.controller;

import com.example.boardPage.dto.UserDTO;
import com.example.boardPage.service.UserService;
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

    public UserController(UserService userService){ // @RequiredArgsConstructor
        this.userService = userService;
    }

    //회원가입
    @PostMapping("/users")
    public ResponseEntity<String> register(@RequestBody UserDTO userDto){ //Dto : UserDto userDto
        try{
            userService.register(userDto); //userDto
            return ResponseEntity.ok("회원가입 성공");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during registration"); // 상태 코드 500
    }

    }

    //로그인
    @PostMapping("/auth")
    public  ResponseEntity<String> login(@RequestBody UserDTO loginRequest){
        try {
            //로그인 후, jwt 토큰 반환
            String token = userService.login(loginRequest);
            return ResponseEntity.ok(token);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("로그인 실패 " + e.getMessage());
        }
    }
}
