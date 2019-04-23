package com.bxia.bookstore.exception;

public class UserAlreadyExistsException extends ServiceException{
    public UserAlreadyExistsException(String msg) {
        super(msg);
    }
}
