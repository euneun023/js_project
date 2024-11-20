package com.example.boardPage.service;

import com.example.boardPage.dto.JwtManager;
import com.example.boardPage.dto.User;
import com.example.boardPage.repository.UserRepository;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import security.JwtManager;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtManager jwtManager;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    //회원가입
    public String registerUser(User user){  //DTO : UserDto userDto

        //이메일 중복 확인
        if (userRepository.existsByEmail(user.getEmail())){
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        //이름 중복 확인
        if (userRepository.existsByUsername(user.getUsername())){
            throw new IllegalArgumentException("이미 사용중인 사용자 입니다.");
        }

        //비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword); //암호화된 비밀번호 설정

        //활성화된 사용자(default)
        user.setEnabled(true);

        //회원 저장
        userRepository.save(user);
        return "회원가입 완료";

        /* DTO일 경우
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getName());
        user.setPassword(encodeePassword);
        user.setEnabled(true);
         */

    }



    //로그인
    public String login(User loginRequest){
        //이메일 일치 테스트
        User user = userRepository.findByEmail(loginRequest.getEmail());

        if(user == null){
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }
        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new IllegalThreadStateException("비밀번호가 일치하지 않습니다.");
        }
        //JWT 토큰 생성
        return jwtManager.generateToken(user.getUsername());



    }

}
