package com.bxia.bookstore.controller;

import com.bxia.bookstore.domain.User;
import com.bxia.bookstore.service.UserService;
import com.bxia.bookstore.web.CommonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    @PostMapping(value = "/login")
    public CommonResponse login(String username, String password){
        User user = userService.login(username, password);
        return CommonResponse.ok(user);
    }
}
