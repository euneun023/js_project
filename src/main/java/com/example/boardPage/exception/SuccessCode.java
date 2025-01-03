package com.example.boardPage.exception;

import lombok.Getter;

@Getter
public enum SuccessCode {

    SELECT_SUCCESS(200, "데이터 조회 성공"),
    DELETE_SUCCESS(200, "데이터 삭제 성공"),
    INSERT_SUCCESS(201, "데이터 삭제 성공"),
    UPDATE_SUCCESS(204, "데이터 삭제 성공"),

    ;




    private final int status;
    private final String message;


    SuccessCode (int status, String message){
        this.status=status;
        this.message=message;
    }

}
