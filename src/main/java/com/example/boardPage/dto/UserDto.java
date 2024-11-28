package com.example.boardPage.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {  //추후 Dto로 변환 위함
    private String email;
    private String name;
    private String password;

}
