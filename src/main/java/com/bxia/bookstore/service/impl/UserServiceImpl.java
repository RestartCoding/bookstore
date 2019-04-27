package com.bxia.bookstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bxia.bookstore.domain.User;
import com.bxia.bookstore.exception.ServiceException;
import com.bxia.bookstore.exception.UserAlreadyExistsException;
import com.bxia.bookstore.exception.UserNotFoundException;
import com.bxia.bookstore.mapper.UserMapper;
import com.bxia.bookstore.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) throws ServiceException {
        User user = userMapper.selectOne(new QueryWrapper<User>().allEq(
                Map.of("username", username, "password", password)));
        if (null == user) {
            throw new UserNotFoundException("用户名或密码错误");
        }
        return user;
    }

    @Override
    public boolean register(User user) {
        User one = userMapper.selectOne(new QueryWrapper<>(user, "username"));
        if (null != one) {
            throw new UserAlreadyExistsException("用户名[" + user.getUsername() + "]已存在");
        }
        return userMapper.insert(user) == 1;
    }

    @Override
    public User getUserInfo(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public boolean updateUserInfo(User user) {
        return userMapper.updateById(user) == 1;
    }

    @Override
    public boolean deleteUser(int id) {
        return userMapper.deleteById(id) == 1;
    }
}