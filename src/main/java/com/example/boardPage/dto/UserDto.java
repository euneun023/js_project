package com.example.boardPage.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class UserDto {  //추후 Dto로 변환 위함

    @NotNull
    private String email;
    @NotNull
    //@Size(min =2, max = 10)
    private String username;
    @NotNull
    private String password;
    @NotNull
    private Boolean enabled;  //true 기본 설정할지 !

}
