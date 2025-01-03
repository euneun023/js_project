package com.example.boardPage.exception;

import lombok.Getter;

@Getter
public class BusinessExceptionHandler extends RuntimeException {

    private final ErrorCode errorCode;

    public BusinessExceptionHandler(ErrorCode errorCode){
        super(errorCode.getMessage()); //RuntimeException에 에러메시지 전달
        this.errorCode = errorCode;
        //super(message, errorCode);
    }

}


//RuntimeException은 런타임 중 발생하는 예외를 처리하는데 사용
//감지하는 에러 종류 : NullPointerException , ArrayIndexOutOfBoundsException , ClassCastException
// IllegalArgumentException , ArithmeticException
