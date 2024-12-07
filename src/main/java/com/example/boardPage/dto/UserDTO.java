package com.example.boardPage.dto;


import com.example.boardPage.entity.User;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class UserDTO {  //추후 Dto로 변환 위함

    @NotNull
    private String email;
    @NotNull
    //@Size(min =2, max = 10)
    private String username;
    @NotNull
    private String password;
    @NotNull
    private Boolean enabled;  //true 기본 설정할지 !

    @Builder
    public UserDTO(String email, String username, String password, Boolean enabled){
        this.email=email;
        this.username=username;
        this.password=password;
        this.enabled=enabled;
    }

    public User toEntity(){
        return User.builder()
                .email(email)
                .username(username)
                .password(password)
                .enabled(enabled)
                .build();
    }

    public UserDTO toDTO(User user){
        return UserDTO.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .enabled(user.isEnabled()) //getEnabled 는 없음
                .build();
    }

}
