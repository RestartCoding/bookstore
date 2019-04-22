package com.bxia.bookstore.exception;

public class ServiceException extends RuntimeException{
    public ServiceException(String msg){
        super(msg);
    }
}
