package com.bxia.bookstore.exception;

public class UserNotFoundException extends ServiceException{

    public UserNotFoundException(String msg){
        super(msg);
    }
}
