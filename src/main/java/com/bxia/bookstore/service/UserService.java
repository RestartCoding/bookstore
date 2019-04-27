package com.bxia.bookstore.service;

import com.bxia.bookstore.domain.User;
import com.bxia.bookstore.exception.ServiceException;
import org.springframework.security.access.prepost.PreAuthorize;

public interface UserService {

    User login(String username, String password) throws ServiceException;

    boolean register(User user);

    @PreAuthorize("hasRole('SYSTEM')")
    User getUserInfo(int id);

    boolean updateUserInfo(User user);

    boolean deleteUser(int id);
}