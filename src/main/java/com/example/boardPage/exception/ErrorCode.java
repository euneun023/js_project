package com.example.boardPage.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // 대표예외 처리
    INVALID_INPUT_ERROR(400, "잘못된 입력값입니다."),
    NOT_VALID_ERROR(400, "유효하지 않은 형식의 요청입니다."),
    REQUEST_BODY_MISSING_ERROR(400, "Required request body is missing"),
    NO_RESOURCE_FOUND_ERROR(400, "No static resource"),
    BUSINESS_EXCEPTION_ERROR(500, "business Exception 발생"),

    //회원 문제
    USER_NOT_FOUND(500, "유저를 찾지 못했습니다."),
    DUPLICATE_EMAIL(500,"이미 존재하는 이메일입니다."),
    PASSWORDS_DO_NOT_MATCH(500,"비밀번호가 일치하지 않습니다."),
    INVALID_PASSWORD_FORMAT(500,"비밀번호 형식이 올바르지 않습니다."),
    // SQL 문제
    INSERT_ERROR(500, "데이터 삽입 문제 발생"),
    UPDATE_ERROR(500, "데이터 업데이트 문제 발생"),
    DELETE_ERROR(500, "데이터 삭제 문제 발생"),
    // 권한 문제
    FORBIDDEN_ERROR(500, "관리자 권한이 아닙니다."),


    ;


    private final int status;
   // private final String code;
    private final String message;


    ErrorCode(int status, String message){
        this.status = status;
        this.message = message;
    }

}
