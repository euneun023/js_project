package com.example.boardPage.exception;

import lombok.Builder;

public class ErrorResponse {
    private int status;
    private String message;

    private String reason;

    @Builder
    public ErrorResponse(ErrorCode errorCode, String reason){
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
        this.reason = reason;

    }



}
