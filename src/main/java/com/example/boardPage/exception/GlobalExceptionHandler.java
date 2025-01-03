package com.example.boardPage.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    //ErrorCode
    @ExceptionHandler(BusinessExceptionHandler.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessExceptionHandler e){
        log.error("BusinessException : ", e);
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode(), e.getErrorCode().getMessage());
        return ResponseEntity.status(e.getErrorCode().getStatus()).body(errorResponse);

        //ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.NOT_FOUND, "Resource not found"); 팩토리메서드
    }

}
