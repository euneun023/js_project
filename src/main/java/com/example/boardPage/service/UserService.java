package com.example.boardPage.service;

import com.example.boardPage.dto.UserDto;
import com.example.boardPage.security.JwtManager;
import com.example.boardPage.entity.User;
import com.example.boardPage.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtManager jwtManager;
    private final PasswordEncoder passwordEncoder; //생성자

    public UserService(UserRepository userRepository, JwtManager jwtManager, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.jwtManager = jwtManager;
        this.passwordEncoder = passwordEncoder;
    }

    //회원가입
    public void register(UserDto userDTO){  //DTO : UserDto userDto

        userRepository.findByEmail(userDTO.getEmail()).ifPresent(user ->{
            throw new IllegalArgumentException("이미 사용중인 이메일 주소입니다.");
        });
        userRepository.findByUsername(userDTO.getUsername()).ifPresent(user ->{
            throw new IllegalArgumentException("이미 사용중인 닉네임입니다.");
        });

        //회원 저장
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        //user.setEnabled(userDTO.getEnabled() != null ? userDTO.getEnabled() : true); // 필요한건가?
        user.setEnabled(true);

        userRepository.save(user);


    }



    //로그인
    public String login(UserDto loginRequest){

        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없습니다.")
        );

        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new IllegalThreadStateException("비밀번호가 일치하지 않습니다.");
        }
        //JWT 토큰 생성
        return jwtManager.generateToken(user.getUsername());



    }

}
