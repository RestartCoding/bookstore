package com.bxia.bookstore.web;

import com.bxia.bookstore.exception.UserAlreadyExistsException;
import com.bxia.bookstore.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    public CommonResponse processUserNotFoundException(UserNotFoundException e){
        return CommonResponse.error(e.getMessage());
    }

    @ExceptionHandler({UserAlreadyExistsException.class})
    public CommonResponse processUserAlreadyExistsException(UserAlreadyExistsException e){
        return CommonResponse.error(e.getMessage());
    }
}
