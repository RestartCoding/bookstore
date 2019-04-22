package com.bxia.bookstore.service;

import com.bxia.bookstore.domain.User;
import com.bxia.bookstore.exception.ServiceException;

public interface UserService {

    User login(String username, String password) throws ServiceException;
}
