package com.bxia.bookstore.controller;

import com.bxia.bookstore.domain.User;
import com.bxia.bookstore.service.UserService;
import com.bxia.bookstore.web.CommonResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@Valid
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户登录
     * @param user 用户
     * @return 用户信息
     */
    @PostMapping("/login")
    public CommonResponse login(@RequestBody User user){
        User result = userService.login(user.getUsername(), user.getPassword());
        return CommonResponse.ok(result);
    }

    @PostMapping("/register")
    public CommonResponse register(@ModelAttribute User user){
        return CommonResponse.ok(userService.register(user));
    }
}
